package com.misc;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.util.mxCellRenderer;
import org.jgrapht.Graph;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JGraphTExampleTest {

    Graph<String, DefaultEdge> g;

    @BeforeEach
    public void createGraph() throws IOException {
        File imgFile = new File("src/test/resources/graph.png");
        imgFile.createNewFile();

        g = new DefaultDirectedGraph<>(DefaultEdge.class);

        String x1 = "x1";
        String x2 = "x2";
        String x3 = "x3";

        g.addVertex(x1);
        g.addVertex(x2);
        g.addVertex(x3);

        g.addEdge(x1, x2);
        g.addEdge(x2, x3);
        g.addEdge(x3, x1);
    }

    @Test
    public void givenAdaptedGraph_whenWriteBufferedImage_thenFileShouldExist() throws IOException {

        JGraphXAdapter<String, DefaultEdge> graphAdapter = new JGraphXAdapter<>(g);
        mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
        layout.execute(graphAdapter.getDefaultParent());

        BufferedImage image = mxCellRenderer
                .createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);

        File imgFile = new File("src/test/resources/graph.png");
        ImageIO.write(image, "PNG", imgFile);

        assertTrue(imgFile.exists());
    }

}
