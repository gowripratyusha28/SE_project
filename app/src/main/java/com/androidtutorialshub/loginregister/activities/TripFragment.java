package com.androidtutorialshub.loginregister.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.androidtutorialshub.loginregister.R;

import java.util.Stack;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TripFragment#} factory method to
 * create an instance of this fragment.
 */
public class TripFragment extends Fragment {

    public static String message;
    public static String totalcost;
    public static String totaltime;

    public static String message1;
    public static String totalcost1;
    public static String totaltime1;

    private Spinner mCategorySpinner;
    private int mCategory;

    public static int cost1;
    public static int[] placesorder;

    public TripFragment() {
        // Required empty public constructor
    }


    public String placenames[] = {"","RamaKrishna Beach", "Simhachalam", "Yarada Beach", "Kailasgiri Hill Park", "Kambalakonda Wild Life Sanctuary",
            "Indira Gandhi Zoological Park", "RushiKonda Beach", "Vuda Park", "City Central Park", "CMR Central Mall", "TU 142 Air Craft Museum", "Dolphins Nose" };

        @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_trip, container, false);
        mCategorySpinner = (Spinner) view.findViewById(R.id.spinner_category);
        setupSpinner();
        Button btn =(Button) view.findViewById(R.id.trip);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int[] isplace = new int[13];
                boolean[] hasplace = new boolean[13];
                CheckBox place1 = (CheckBox) view.findViewById(R.id.place1);
                hasplace[1] = place1.isChecked();
                place1.setChecked(false);
                CheckBox place2 = (CheckBox) view.findViewById(R.id.place2);
                hasplace[2] = place2.isChecked();
                place2.setChecked(false);
                CheckBox place3 = (CheckBox) view.findViewById(R.id.place3);
                hasplace[3] = place3.isChecked();
                place3.setChecked(false);
                CheckBox place4 = (CheckBox) view.findViewById(R.id.place4);
                hasplace[4] = place4.isChecked();
                place4.setChecked(false);
                CheckBox place5 = (CheckBox) view.findViewById(R.id.place5);
                hasplace[5] = place5.isChecked();
                place5.setChecked(false);
                CheckBox place6 = (CheckBox) view.findViewById(R.id.place6);
                hasplace[6] = place6.isChecked();
                place6.setChecked(false);
                CheckBox place7 = (CheckBox) view.findViewById(R.id.place7);
                hasplace[7] = place7.isChecked();
                place7.setChecked(false);
                CheckBox place8 = (CheckBox) view.findViewById(R.id.place8);
                hasplace[8] = place8.isChecked();
                place8.setChecked(false);
                CheckBox place9 = (CheckBox) view.findViewById(R.id.place9);
                hasplace[9] = place9.isChecked();
                place9.setChecked(false);
                CheckBox place10 = (CheckBox) view.findViewById(R.id.place10);
                hasplace[10] = place10.isChecked();
                place10.setChecked(false);
                CheckBox place11 = (CheckBox) view.findViewById(R.id.place11);
                hasplace[11] = place11.isChecked();
                place11.setChecked(false);
                CheckBox place12 = (CheckBox) view.findViewById(R.id.place12);
                hasplace[12] = place12.isChecked();
                place12.setChecked(false);
                int[][] cost_matrix = {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 468, 407, 270, 474, 200, 266, 121, 111, 125, 75, 399},
                        {0, 468, 0, 707, 462, 354, 369, 450, 406, 421, 398, 448, 673},
                        {0, 407, 707, 0, 629, 729, 577, 620, 453, 376, 409, 419, 131},
                        {0, 270, 462, 629, 0, 497, 200, 259, 216, 255, 210, 240, 558},
                        {0, 474, 354, 729, 497, 0, 393, 489, 436, 458, 395, 452, 686},
                        {0, 200, 369, 577, 200, 393, 0, 147, 160, 177, 134, 183, 468},
                        {0, 266, 450, 620, 259, 489, 147, 0, 202, 278, 216, 231, 570},
                        {0, 121, 406, 453, 216, 436, 160, 202, 0, 130, 106, 94, 416},
                        {0, 111, 421, 376, 255, 458, 177, 278, 130, 0, 110, 115, 342},
                        {0, 125, 398, 409, 210, 395, 134, 216, 106, 110, 0, 117, 378},
                        {0, 75, 448, 419, 240, 452, 183, 231, 94, 115, 117, 0, 398},
                        {0, 399, 673, 131, 558, 686, 468, 570, 416, 342, 378, 398, 0}
                };
                int[][] time_matrix = {
                        {0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0, 0, 0, 0},
                        {0, 0, 30, 40, 21, 38, 16, 23, 9, 8, 9, 4, 38},
                        {0, 30, 0, 72, 28, 26, 24, 34, 27, 27, 26, 30, 66},
                        {0, 40, 72, 0, 64, 81, 57, 68, 41, 34, 37, 39, 12},
                        {0, 21, 28, 64, 0, 37, 12, 19, 15, 18, 15, 17, 56},
                        {0, 38, 26, 81, 37, 0, 31, 40, 34, 36, 34, 39, 75},
                        {0, 16, 24, 57, 12, 31, 0, 12, 14, 14, 11, 16, 42},
                        {0, 23, 34, 68, 19, 40, 12, 0, 17, 23, 21, 20, 58},
                        {0, 9, 27, 41, 15, 34, 14, 17, 0, 10, 8, 4, 37},
                        {0, 8, 27, 34, 18, 36, 14, 23, 10, 0, 5, 8, 31},
                        {0, 9, 26, 37, 15, 34, 11, 21, 8, 5, 0, 9, 35},
                        {0, 4, 30, 39, 17, 39, 16, 20, 4, 8, 9, 0, 37},
                        {0, 38, 66, 12, 56, 75, 42, 58, 37, 31, 35, 37, 0}
                };
                int[][] adjacency_matrix = new int[13][13];
                if(mCategory == 2){
                    adjacency_matrix = cost_matrix;
                }
                else{
                    adjacency_matrix = time_matrix;
                }
                int i,j=1;
                int completed[] = new int[13];
                int num_of_nodes = 0;
                for(i=1;i<13;i++){
                    completed[i] = 0;
                    if(hasplace[i]) {
                        isplace[i] = 1;
                        num_of_nodes+=1;
                    }
                    else isplace[i] = 0;
                }
                int nodes[] = new int[num_of_nodes+1];
                for(i=1;i<13;i++){
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
                placesorder = new int[num_of_nodes+1];
                int cost = 0, time = 0;
                TSPNearestNeighbour tspNearestNeighbour = new TSPNearestNeighbour();
                placesorder = tspNearestNeighbour.tsp(new_adj,nodes);

                message1 = "";
                Prims prims = new Prims();
                prims.mincost(1,new_adj,nodes,completed,num_of_nodes);

                for(i=1;i<=num_of_nodes;i++){
                    if(i!=num_of_nodes) {
                        cost += cost_matrix[placesorder[i]][placesorder[i + 1]];
                        time += time_matrix[nodes[i]][nodes[i+1]];
                    }
                }
                totalcost = "The total cost required to travel is:\n₹" + cost;
                totaltime = "The total time taken to travel is:\n" + time + " minutes";
                totalcost1 = "The total cost required to travel is:\n" + cost;
                totaltime1 = "The total time taken to travel is:\n" + time + " minutes";

                Intent intentResult = new Intent(getContext(), ResultActivity.class);
                startActivity(intentResult);
            }
        });
        return view;
    }

    public class Prims {
        int n,cost1 = 0;

        //Function for TSP algo
        public int least(int c, int[][] ary,int[] completed,int num_of_nodes) {
            int i, nc = 999;
            int min = 999, kmin = 0;//initiated kmin to 0

            n = num_of_nodes;

            for (i = 1; i <= n; i++) {
                if ((ary[c][i] != 0) && (completed[i] == 0))
                    if (ary[c][i] + ary[i][c] < min) {
                        min = ary[i][1] + ary[c][i];
                        kmin = ary[c][i];
                        nc = i;
                    }
            }

            if (min != 999)
                cost1 += kmin;

            return nc;
        }

        //Function to determine minimum cost
        public void mincost(int city, int[][] ary, int[] nodes,int[] completed,int num_of_nodes) {
            int ncity;

            completed[city] = 1;

            message1 += placenames[nodes[city]] + "\n";
            //System.out.print(nodes[city]);
            ncity = least(city, ary,completed,num_of_nodes);

            if (ncity == 999) return;

            mincost(ncity, ary, nodes,completed,num_of_nodes);
        }
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
            message = "1. "+ placenames[nodes[1]] + "\n";
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
                    message += j + ". " + placenames[nodes[dst]] + "\n";
                    j++;
                    //System.out.print(nodes[dst] + "\t");
                    minFlag = false;
                    continue;
                }
                stack.pop();
            }
            return nodesorder;
        }
    }

    /**
     * Setup the dropdown spinner that allows the user to select the gender of the pet.
     */
    private void setupSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter categorySpinnerAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.category_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        categorySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mCategorySpinner.setAdapter(categorySpinnerAdapter);

        // Set the integer mSelected to the constant values
        mCategorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.cost))) {
                        mCategory = 2;
                    } else if (selection.equals(getString(R.string.time))) {
                        mCategory = 3;
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mCategory = 2;
            }
        });
    }

}
