<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="hu">

<head>

    <c:url value="/resources/js/d3.min.js" var="d3js" />
    <c:url value="/resources/css/graph.css" var="graphCss" />
    <!-- <link rel="stylesheet" type="text/css" href="${graphCss}" /> -->

    <meta charset="UTF-8">
    <title>Graph Directed</title>
    <script src="${d3js}"></script>

    <style>

        body{
            background-color: #5DFF6C;
        }

        svg{
            background-color: white;
            display: block;
            margin: auto;
        }

        #operatorDescription {
                    position: absolute;
                    border: 2px solid black;
                    background-color: cornflowerblue;
                    color: white;
                    font-size: larger;
                    padding: 15px;
                    text-align: center;
                    border-radius: 10px;
                    opacity: 0;
                    pointer-events: none;
                }

        #nodeDescription {
                            position: absolute;
                            border: 2px solid black;
                            background-color: cornflowerblue;
                            color: white;
                            font-size: larger;
                            padding: 15px;
                            text-align: center;
                            border-radius: 10px;
                            opacity: 0;
                            pointer-events: none;
                        }
    </style>

</head>

<body>

    <c:choose>
    <c:when test="${processEntity.done == true && processEntity.error == false}">

    <!-- <button id="next">Next</button>
    <button id="solution">Solution</button> -->

    <p>
	<button id="stepButton">STEP</button>
	<button id="backButton">BACK</button>
	<button id="solutionButton">SOLUTION</button>
	</p>

    <svg width="960" height="600"></svg>

    <div id="operatorDescription"></div>
    <div id="nodeDescription"></div>

    <c:url value="/resources/js/graph.js" var="graphJs" />
    <script src="${graphJs}"></script>
    <script>
        initGraph("${pageContext.request.contextPath}/file/json/${processEntity.processIdentifier}");
    </script>

    <!--
    <script>

        var steps;
        var solution;
        var actualNodeIndex = 0;
		var stepIndex = 0;
		var actualNodeId;

		// http://bl.ocks.org/mbostock/1153292
        var svg = d3.select("svg"),
            width = +svg.attr("width"),
            height = +svg.attr("height");
        var simulation = d3.forceSimulation()
            .force("link", d3.forceLink().distance(50).id(function(d){return d.id;}))
            .force("charge", d3.forceManyBody())
            .force("center", d3.forceCenter(width / 2, height / 2));
        d3.json("http://localhost:8080/graph/file/json/${processEntity.processIdentifier}", function(error, graph) {
            if (error) throw error;
            simulation
                .nodes(graph.nodes)
                .on("tick", ticked);
            simulation.force("link")
                .links(graph.connections);
            // Per-type markers, as they don't inherit styles.
            svg.append("defs").selectAll("marker")
                .data(["suit", "licensing", "resolved"])
                .enter().append("marker")
                .attr("id", function(d) { return d; })
                .attr("viewBox", "0 -5 10 10")
                .attr("refX", 15)
                .attr("refY", -1.5)
                .attr("markerWidth", 6)
                .attr("markerHeight", 6)
                .attr("orient", "auto")
                .append("path")
                .attr("d", "M0,-5L10,0L0,5");
            /*
            var link = svg.append("g")
                .attr("class", "links")
                .selectAll("line")
                .data(graph.connections)
                .enter().append("line")
                .attr("stroke-width", function(d, i) { return 1; });*/
            /*
            var path = svg.append("g").selectAll("path")
                .data(simulation.links())
                .enter().append("path")
                .attr("class", function(d) { return "link " + d.type; })
                .attr("marker-end", function(d) { return "url(#suit)"; });
                */
            var path = svg.append("g").attr("class", "links")
                .selectAll("path")
                .data(graph.connections)
                .enter().append("path")
                .attr("id", function(d){ return "c" + d.source.id + "-" + d.target.id; })
                // .attr("class", function(d) { return "link " + d.type; })
				.attr("class", "futureConnection")
                .attr("marker-end", function(d) { return "url(#suit)"; });
            var node = svg.append("g")
                .attr("class", "futureNode")
                .selectAll("circle")
                .data(graph.nodes)
                .enter().append("circle")
                .attr("id", function(d){ return "n" + d.id; })
                .attr("r", 5)
                //.attr("fill", function(d) { return "steelblue"; })
                .call(d3.drag()
                    .on("start", dragstarted)
                    .on("drag", dragged)
                    .on("end", dragended));
            node.append("title")
                .text(function(d) { return d.id; });
            function ticked() {
                /*
                link
                    .attr("x1", function(d) { return d.source.x; })
                    .attr("y1", function(d) { return d.source.y; })
                    .attr("x2", function(d) { return d.target.x; })
                    .attr("y2", function(d) { return d.target.y; });*/
                node
                    .attr("cx", function(d) { return d.x; })
                    .attr("cy", function(d) { return d.y; });
                path.attr("d", linkArc)
            }

            steps = graph.steps;
            solution = graph.solution;
			actualNodeId = graph.info.startNodeId;
			console.log(actualNodeId);

            d3.select("#n0")
                .attr("r", 8)
                .attr("class", "actualNode");

            d3.select("#next")
                .on("click", nextNode);

            d3.select("#solution")
                .on("click", showSolution);

			d3.select("#theStep")
				.on("click", performStep);

			d3.selectAll("path")
				.on("click", function(){console.log("GECI");});

        });
        function dragstarted(d) {
            if (!d3.event.active) simulation.alphaTarget(0.3).restart();
            d.fx = d.x;
            d.fy = d.y;
        }
        function dragged(d) {
            d.fx = d3.event.x;
            d.fy = d3.event.y;
        }
        function dragended(d) {
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

		// NEW: Step

		function performStep(){

			var step = steps[stepIndex];

			// active node
			tmpNodeId = "#n" + step.nodeId;
			d3.select(tmpNodeId)
				.style("fill", "orange");

			// close actual node
			var tmpNodeId = "#n" + actualNodeId;
			d3.select(tmpNodeId)
				.style("stroke", "black")
				.style("fill", "grey");

			// open new nodes
			for(i=0; i<step.openedNodeIds.length; i++){
				console.log(step.openedNodeIds[i]);
				var tmpNodeId = "#n" + step.openedNodeIds[i];
				d3.select(tmpNodeId)
					.style("stroke", "black")
					// .style("fill", "gray");
			}

			stepIndex++;
			actualNodeId = step.nodeId;

		}

        // Node steps

        function nextNode() {
            var actualId = "#n" + steps[actualNodeIndex];
            var nextId = "#n" + steps[actualNodeIndex + 1];
            console.log(actualId + " - " + nextId);
            d3.select(actualId)
                .transition()
                .duration(500)
                .attr("r", 5)
                .style("fill", "#ccc")
                //.attr("class", "nodes");
            d3.select(nextId)
                .transition()
                .duration(500)
                .attr("r", 8)
                .style("fill", "orange")
                //.attr("class", "actualNode");
            actualNodeIndex++;
        }

        function showSolution() {
            for(i=0; i<solution.length-1; i++){
                var connectionId = "#c" + solution[i] + "-" + solution[i+1];
                d3.select(connectionId)
                    .style("stroke", "red");
            }
        }

    </script>
    -->

    </c:when>
    <c:when test="${processEntity.done == true && processEntity.error == true}">
        <p><spring:message code="${processEntity.errorMessage}" /></p>
    </c:when>

    </c:choose>

</body>

</html>