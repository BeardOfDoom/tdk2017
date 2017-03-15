var svg = d3.select("svg"),
	width = +svg.attr("width"),
	height = +svg.attr("height");

var simulation = d3.forceSimulation()
	.force("link", d3.forceLink().distance(50).id(function(d){return d.id;}))
	.force("charge", d3.forceManyBody())
	.force("center", d3.forceCenter(width / 2, height / 2));

var steps;
var nodes;
var operators;

var stepIndex = 0;
var activeNodeId;
var searchAlgorithmType;
var connectionHistory = [];

function initGraph(jsonUrl){

	d3.json(jsonUrl, function(error, graph) {
		
		if (error) throw error;
		
		simulation
			.nodes(graph.nodes)
			.on("tick", ticked);
		
		simulation.force("link")
			.links(graph.connections);
		
		// TODO
		svg.append("defs").selectAll("marker")
			// .data(["futureMarker", "normalMarker"])
			.data(graph.connections)
			.enter().append("marker")
			.attr("id", function(d) { return "m" + d.source.id + "-" + d.operatorId + "-" + d.target.id; })
			.attr("viewBox", "0 -5 10 10")
			.attr("refX", 15)
			.attr("refY", -1.5)
			.attr("markerWidth", 6)
			.attr("markerHeight", 6)
			.attr("orient", "auto")
			.style("fill", "lightgray")
			.append("path")
			.attr("d", "M0,-5L10,0L0,5");
		
		var path = svg.append("g")
			.selectAll("path")
			.data(graph.connections)
			.enter().append("path")
			.attr("id", function(d){ return "c" + d.source.id + "-" + d.operatorId + "-" + d.target.id; })
			// .attr("class", "futureConnection")
			.style("fill", "none")
			.style("stroke", "lightgray")
			.style("stroke-width", "1")
			// .attr("marker-end", function(d) { return "url(#futureMarker)"; });
			.attr("marker-end", function(d) { return "url(#m" + d.source.id + "-" + d.operatorId + "-" + d.target.id + ")"; });
		
		var node = svg.append("g")
			.selectAll("circle")
			.data(graph.nodes)
			.enter().append("circle")
			.attr("id", function(d){ return "n" + d.id; })
			// .attr("class", "futureNode")
			.attr("r", 5)
			.style("stroke", "lightgray")
			.style("fill", "white")
			.call(d3.drag()
				.on("start", dragStarted)
				.on("drag", dragged)
				.on("end", dragEnded));
		
		// TEST -------------------------------------
		var op = svg.append("g")
			.selectAll("circle")
			.data(graph.connections)
			.enter().append("circle")
			.attr("id", function(d){ return "o" + d.source.id + "-" + d.operatorId + "-" + d.target.id; })
			// .attr("class", "futureNode")
			.attr("r", 3)
			.style("fill", "lightgray")
			.on("mouseover", bigOperator)
			.on("mouseout", smallOperator);
		// TEST -------------------------------------
		
		node.append("title")
			.text(function(d) { return d.id; });
		
		path.append("title")
			.text(function(d) { return d.source.id + "-" + d.operatorId + "-" + d.target.id; });
		
		function ticked() {
			
			node
				.attr("cx", function(d) { return d.x; })
				.attr("cy", function(d) { return d.y; });
			
			path.attr("d", linkArc);
			
			op
				.attr("cx", function(d){
					var dist = Math.hypot(d.source.x - d.target.x, d.source.y - d.target.y);
					var tmpPathId = "#c" + d.source.id + "-" + d.operatorId + "-" + d.target.id;
					// console.log(document.getElementById("c" + d.source.id + "-" + d.operatorId + "-" + d.target.id));
					// console.log(d3.select(tmpPathId));
					return document.getElementById("c" + d.source.id + "-" + d.operatorId + "-" + d.target.id).getPointAtLength(dist / 2).x;
					// return d3.select(tmpPathId).getPointAtLength(dist / 2).x;
				})
				.attr("cy", function(d){
					var dist = Math.hypot(d.source.x - d.target.x, d.source.y - d.target.y);
					return document.getElementById("c" + d.source.id + "-" + d.operatorId + "-" + d.target.id).getPointAtLength(dist / 2).y;
				});
			
		}
		
		// highlight the start node
		var startNodeId = "#n" + graph.info.startNodeId;
		d3.select(startNodeId)
			// .attr("class", "activeNode");
			.style("r", "7")
			.style("fill", "orange")
			.style("stroke", "black");
		
		d3.select("#stepButton")
			.on("click", step);
		
		steps = graph.steps;
		nodes = graph.nodes;
		operators = graph.operators;
		activeNodeId = graph.info.startNodeId;
		searchAlgorithmType = graph.info.searchAlgorithmType;
		
		if(searchAlgorithmType=="backtrack"){
			for(i=0; i<nodes.length; i++){
				nodes[i].counter = 0;
			}
		}
		
	});

}

// TEST -------------------------
function bigOperator(d){
	// highlight the operator circle
	d3.select(this)
		.transition()
		.duration(100)
		.attr("r", 5);
	
	// search for the operator information
	var information;
	for(i in operators){
		if(operators[i].id==d.operatorId){
			information = operators[i].information;
			break;
		}
	}
	
	// show the info box
	// console.log(information);
	d3.select("#operatorDescription")
                        .style("left", (d3.event.pageX + 20) + "px")
                        .style("top", (d3.event.pageY - 5) + "px")
                        .html(d.source.id + "-->" + d.target.id + "<br/>" + d.operatorId + "<br/>" + information)
                        .transition()
                        .duration(100)
                        .style("opacity", 0.8);
}
function smallOperator(d){
	d3.select(this)
		.transition()
		.duration(100)
		.attr("r", 3);
	
	d3.select("#operatorDescription")
                        .transition()
                        .duration(100)
                        .style("opacity", 0);
}
// TEST -------------------------

function dragStarted(d) {
	if (!d3.event.active) simulation.alphaTarget(0.3).restart();
	d.fx = d.x;
	d.fy = d.y;
}

function dragged(d) {
	d.fx = d3.event.x;
	d.fy = d3.event.y;
}

function dragEnded(d) {
	if (!d3.event.active) simulation.alphaTarget(0);
	d.fx = null;
	d.fy = null;
}

function linkArc(d) {
	var dx = d.target.x - d.source.x,
		dy = d.target.y - d.source.y,
		dr = Math.sqrt(dx * dx + dy * dy);
	return "M" + d.source.x + "," + d.source.y + "A" + dr + "," + dr + " 0 0,1 " + d.target.x + "," + d.target.y;
}

function step(){
	
	// console.log(document.getElementById("c0-OP0-1").getPointAtLength(10));
	
	if(stepIndex<steps.length){
		if(searchAlgorithmType=="tree"){
			treeStep();
		}else if(searchAlgorithmType=="backtrack"){
			backtrackStep();
		}
	}
	
}

function treeStep(){
	
	// console.log("STEP");
	
	var currentStep = steps[stepIndex];
	// console.log(currentStep);
	var tmpNodeId;
	
	// open new nodes
	for(i=0; i<currentStep.openedNodeIds.length; i++){
		tmpNodeId = "#n" + currentStep.openedNodeIds[i];
		d3.select(tmpNodeId)
			.transition()
			.duration(500)
			.style("r", "5")
			.style("stroke", "black");
	}
	
	// open new connections
	// console.log("CONNECTIONS");
	for(i=0; i<currentStep.openedOperatorIds.length; i++){
		var tmpConnectionId = "#c" + activeNodeId + "-" + currentStep.openedOperatorIds[i] + "-" + currentStep.openedNodeIds[i];
		// console.log(tmpConnectionId);
		d3.select(tmpConnectionId)
			.transition()
			.duration(500)
			.style("stroke", "black");
		
		var tmpMarkerId = "#m" + activeNodeId + "-" + currentStep.openedOperatorIds[i] + "-" + currentStep.openedNodeIds[i];
		// console.log(tmpConnectionId);
		d3.select(tmpMarkerId)
			.transition()
			.duration(500)
			.style("fill", "black");
		
		var tmpOperatorId = "#o" + activeNodeId + "-" + currentStep.openedOperatorIds[i] + "-" + currentStep.openedNodeIds[i];
		d3.select(tmpOperatorId)
			.transition()
			.duration(500)
			.style("fill", "black");
	}
	
	// highlight the new active node
	// console.log(currentStep.nodeId);
	tmpNodeId = "#n" + currentStep.nodeId;
	// console.log(tmpNodeId);
	d3.select(tmpNodeId)
		.transition()
		.duration(500)
		.style("r", "7")
		.style("fill", "orange")
		.style("stroke", "black");
	
	// make the last active node closed
	tmpNodeId = "#n" + activeNodeId;
	d3.select(tmpNodeId)
		.transition()
		.duration(500)
		.style("r", "5")
		.style("fill", "gray")
		.style("stroke", "black");
	
	stepIndex++;
	activeNodeId = currentStep.nodeId;
	
}

function backtrackStep(){
	
	var currentStep = steps[stepIndex];
	var tmpNodeId;
	
	//console.log(currentStep);
	
	if(currentStep.back==true){
		
		// console.log("BACK");
		
		// highlight the new active node
		tmpNodeId = "#n" + currentStep.nodeId;
		d3.select(tmpNodeId)
			.transition()
			.duration(500)
			.style("r", "7")
			.style("fill", "orange")
			.style("stroke", "black");
		
		// make the last active node non-visited
		tmpNodeId = "#n" + activeNodeId;
		// update the counter
		// console.log(d3.select(tmpNodeId).datum().counter);
		d3.select(tmpNodeId).datum().counter--;
		// console.log(d3.select(tmpNodeId).datum().counter);
		if(d3.select(tmpNodeId).datum().counter==0){
			d3.select(tmpNodeId)
				.transition()
				.duration(500)
				.style("r", "5")
				.style("fill", "white")
				.style("stroke", "lightgray");
		}else{
			d3.select(tmpNodeId)
				.transition()
				.duration(500)
				.style("r", "5")
				.style("fill", "gray")
				.style("stroke", "black");
		}
		
		var tmpConnectionId = "#c" + connectionHistory[connectionHistory.length - 1];
		// console.log(tmpConnectionId);
		d3.select(tmpConnectionId)
			.transition()
			.duration(500)
			.style("stroke", "lightgray");
		
		var tmpMarkerId = "#m" + connectionHistory[connectionHistory.length - 1];
		// console.log(tmpConnectionId);
		d3.select(tmpMarkerId)
			.transition()
			.duration(500)
			.style("fill", "lightgray");
		
		connectionHistory.pop();
		// console.log(connectionHistory);
		
	}else{
		
		// console.log("FORWARD");
		
		// upadte the counter
		// console.log(d3.select("#n0").datum());
		
		// highlight the new active node
		tmpNodeId = "#n" + currentStep.nodeId;
		// console.log(d3.select(tmpNodeId).datum().counter);
		d3.select(tmpNodeId)
			.transition()
			.duration(500)
			.style("r", "7")
			.style("fill", "orange")
			.style("stroke", "black");
		// update the counter
		d3.select(tmpNodeId).datum().counter++;
		// console.log(d3.select(tmpNodeId).datum().counter);
		
		// highlight connection
		var tmpConnectionId = "#c" + activeNodeId + "-" + currentStep.operatorId + "-" + currentStep.nodeId;
		d3.select(tmpConnectionId)
			.transition()
			.duration(500)
			.style("stroke", "black");
		
		var tmpMarkerId = "#m" + activeNodeId + "-" + currentStep.operatorId + "-" + currentStep.nodeId;
		// console.log(tmpConnectionId);
		d3.select(tmpMarkerId)
			.transition()
			.duration(500)
			.style("fill", "black");
			
		// push new element to connection history
		connectionHistory.push(activeNodeId + "-" + currentStep.operatorId + "-" + currentStep.nodeId);
		// console.log(connectionHistory);
		
		// make the last active node visited
		tmpNodeId = "#n" + activeNodeId;
		d3.select(tmpNodeId)
			.transition()
			.duration(500)
			.style("r", "5")
			.style("fill", "gray")
			.style("stroke", "black");
		
	}
	
	stepIndex++;
	activeNodeId = currentStep.nodeId;
	
}