<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="hu">

<head>

    <c:url value="/resources/js/d3.min.js" var="d3js" />

    <meta charset="UTF-8">
    <title>Graph Directed</title>
    <script src="${d3js}"></script>

    <style>
        .link {
            fill: none;
            stroke: #666;
            stroke-width: 1.5px;
        }
        #licensing {
            fill: green;
        }
        .link.licensing {
            stroke: green;
        }
        .link.resolved {
            stroke-dasharray: 0,2 1;
        }
        circle {
            fill: #ccc;
            stroke: #333;
            stroke-width: 1.5px;
        }
        text {
            font: 10px sans-serif;
            pointer-events: none;
            text-shadow: 0 1px 0 #fff, 1px 0 0 #fff, 0 -1px 0 #fff, -1px 0 0 #fff;
        }
    </style>

</head>

<body>

    <svg width="960" height="600"></svg>

    <script>

		// http://bl.ocks.org/mbostock/1153292
        var svg = d3.select("svg"),
            width = +svg.attr("width"),
            height = +svg.attr("height");
        var simulation = d3.forceSimulation()
            .force("link", d3.forceLink().distance(100))
            .force("charge", d3.forceManyBody())
            .force("center", d3.forceCenter(width / 2, height / 2));
        d3.json("http://localhost:8080/graph/file/static", function(error, graph) {
            if (error) throw error;
            simulation
                .nodes(graph.nodes)
                .on("tick", ticked);
            simulation.force("link")
                .links(graph.links);
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
                .data(graph.links)
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
                .data(graph.links)
                .enter().append("path")
                .attr("class", function(d) { return "link " + d.type; })
                .attr("marker-end", function(d) { return "url(#suit)"; });
            var node = svg.append("g")
                .attr("class", "nodes")
                .selectAll("circle")
                .data(graph.nodes)
                .enter().append("circle")
                .attr("r", 5)
                .attr("fill", function(d) { return "steelblue"; })
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
    </script>

</body>

</html>