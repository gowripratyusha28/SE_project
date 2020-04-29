package com.androidtutorialshub.loginregister.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.androidtutorialshub.loginregister.R;

import org.w3c.dom.Text;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TripFragment#} factory method to
 * create an instance of this fragment.
 */
public class TripFragment extends Fragment {

    public static String message;
    public static String totalcost;


    public TripFragment() {
        // Required empty public constructor
    }


    public String placenames[] = {"","RadhaKrishnan Beach", "Simhachalam", "Yarada Beach", "Kailasgiri Hill Park", "Kambalakonda Wild Life Sanctuary",
            "Indira Gandhi Zoological Park", "RishiKonda Beach", "Vuda Park", "City Central Park" };

        @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_trip, container, false);
        Button btn =(Button) view.findViewById(R.id.trip);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int[] isplace = new int[10];
                boolean[] hasplace = new boolean[10];
                CheckBox place1 = (CheckBox) view.findViewById(R.id.place1);
                hasplace[1] = place1.isChecked();
                CheckBox place2 = (CheckBox) view.findViewById(R.id.place2);
                hasplace[2] = place2.isChecked();
                CheckBox place3 = (CheckBox) view.findViewById(R.id.place3);
                hasplace[3] = place3.isChecked();
                CheckBox place4 = (CheckBox) view.findViewById(R.id.place4);
                hasplace[4] = place4.isChecked();
                CheckBox place5 = (CheckBox) view.findViewById(R.id.place5);
                hasplace[5] = place5.isChecked();
                CheckBox place6 = (CheckBox) view.findViewById(R.id.place6);
                hasplace[6] = place6.isChecked();
                CheckBox place7 = (CheckBox) view.findViewById(R.id.place7);
                hasplace[7] = place7.isChecked();
                CheckBox place8 = (CheckBox) view.findViewById(R.id.place8);
                hasplace[8] = place8.isChecked();
                CheckBox place9 = (CheckBox) view.findViewById(R.id.place9);
                hasplace[9] = place9.isChecked();
                int[][] adjacency_matrix = {
                        {0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0},
                        {0, 0, 30, 40, 21, 38, 16, 23, 9, 8},
                        {0, 30, 0, 72, 28, 26, 24, 34, 27, 27},
                        {0, 40, 72, 0, 64, 81, 57, 68, 41, 34},
                        {0, 21, 28, 64, 0, 37, 12, 19, 15, 18},
                        {0, 38, 26, 81, 37, 0, 31, 40, 34, 36},
                        {0, 16, 24, 57, 12, 31, 0, 12, 14, 14},
                        {0, 23, 34, 68, 19, 40, 12, 0, 17, 23},
                        {0, 9, 27, 41, 15, 34, 14, 17, 0, 10},
                        {0, 8, 27, 34, 18, 36, 14, 23, 10, 0}
                };
                int i,j=1;
                int num_of_nodes = 0;
                for(i=1;i<10;i++){
                    if(hasplace[i]) {
                        isplace[i] = 1;
                        num_of_nodes+=1;
                    }
                    else isplace[i] = 0;
                }
                int nodes[] = new int[num_of_nodes+1];
                for(i=1;i<10;i++){
                    if(isplace[i] == 1){
                        nodes[j] = i;
                        j++;
                    }
                }
                int new_adj[][] = new int[num_of_nodes+1][num_of_nodes+1];
                for(i=1;i<=num_of_nodes;i++){
                    for(j=1;j<=num_of_nodes;j++){
                        if(i==j) new_adj[i][i] = 0;
                        else{
                            new_adj[i][j] = adjacency_matrix[nodes[i]][nodes[j]];
                        }
                    }
                }
                int[] placesorder = new int[num_of_nodes+1];
                int cost = 0;
                TSPNearestNeighbour tspNearestNeighbour = new TSPNearestNeighbour();
                placesorder = tspNearestNeighbour.tsp(new_adj,nodes);
                for(i=1;i<=num_of_nodes;i++){
                    if(i!=num_of_nodes) {
                        cost += adjacency_matrix[nodes[i]][nodes[i + 1]];
                    }
                }
                totalcost = "The total time taken to travel is: " + cost;
                Intent intentResult = new Intent(getContext(), ResultActivity.class);
                startActivity(intentResult);
            }
        });
        return view;
    }

    public class TSPNearestNeighbour {

        private int numberOfNodes;
        private Stack<Integer> stack;

        public TSPNearestNeighbour() {
            stack = new Stack<Integer>();
        }

        public int[] tsp(int adjacencyMatrix[][], int nodes[]) {
            numberOfNodes = adjacencyMatrix[1].length - 1;
            int[] visited = new int[numberOfNodes + 1];
            int[] nodesorder = new int[numberOfNodes+1];
            int j=1;
            visited[1] = 1;
            stack.push(1);
            int element, dst = 0, i;
            int min = Integer.MAX_VALUE;
            boolean minFlag = false;
            nodesorder[j] = nodes[1];
            j++;
            message = placenames[nodes[1]] + "\n";
            //System.out.print(nodes[1] + "\t");
            while (!stack.isEmpty()) {
                element = stack.peek();
                i = 1;
                min = Integer.MAX_VALUE;
                while (i <= numberOfNodes) {
                    if (adjacencyMatrix[element][i] > 1 && visited[i] == 0) {
                        if (min > adjacencyMatrix[element][i]) {
                            min = adjacencyMatrix[element][i];
                            dst = i;
                            minFlag = true;
                        }
                    }
                    i++;
                }
                if (minFlag) {
                    visited[dst] = 1;
                    stack.push(dst);
                    nodesorder[j] = nodes[dst];
                    j++;
                    message += placenames[nodes[dst]] + "\n";
                    //System.out.print(nodes[dst] + "\t");
                    minFlag = false;
                    continue;
                }
                stack.pop();
            }
            return nodesorder;
        }
    }

}
