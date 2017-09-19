package com.iterativeWork;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Iterative extends Application{

	//Variable declarations
	private Tab linearSearchTab,mergeTab,sortTab;
	private Label in,out;
	private Button start,startMerge,startSort;
	private TextField input,key,intArray1,intArray2,toBeSorted;
	private TextArea output,outputMerge,outputSort;
	private ComboBox sortOptionSelect;
	private String result,sortType;
	private List<Integer> inputA = new ArrayList<Integer>();
	private List<Integer> inputB = new ArrayList<Integer>();
	private ObservableList<String> sortOptions = FXCollections.observableArrayList("Bubble sort","Insertion sort");
	
	private static Search searcher;
	private static Merge merger;
	private static Sort sorter;
	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Initialize objects for my Search, Merge, and Sort classes
		searcher = new Search();
		merger = new Merge();
		sorter = new Sort();
		//Launch the JavaFX Runtime Thread
		launch(args);
	}
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage theStage) throws Exception {
		// TODO Auto-generated method stub
		//Set Frame title, and tab view
		theStage.setTitle("Search");
		TabPane tabs = new TabPane();
		Scene theScene = new Scene(tabs,500,500);
		
		//Create tabs for Searching, Merging, and Sorting data I/O
		linearSearchTab = new Tab();
		linearSearchTab.setText("Search");
		linearSearchTab.setClosable(false);
		linearSearchTab.setContent(linearSearchPane());
		
		mergeTab = new Tab();
		mergeTab.setText("Merge");
		mergeTab.setClosable(false);
		mergeTab.setContent(mergePane());
		
		sortTab = new Tab();
		sortTab.setText("Sort");
		sortTab.setClosable(false);
		sortTab.setContent(sortPane());
		
		//Add tabs to the view
		tabs.getTabs().addAll(linearSearchTab,mergeTab,sortTab);
		theStage.setScene(theScene);
		//Display the JavaFX Window
		theStage.show();
		
		//Various miscellaneous ActionEvent Listeners
		start.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				result = searcher.search();
				output.appendText(result + "\n");
			}});
		input.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent e) {
				
				// TODO Auto-generated method stub
				String in = input.getText();
				searcher.setInputText(in.split(" "));
				output.appendText("Input text taken\n");
			}
		});
		key.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				searcher.setSearchKey(key.getText());
				output.appendText("User search key taken\n");
			}});
		intArray1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				for(String i : intArray1.getText().split(" ")) 
				{
					inputA.add(Integer.parseInt(i));
				}
				outputMerge.appendText("First Integer Array Taken\n");
				merger.setArray1(inputA);
			}});
		intArray2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				for(String i : intArray2.getText().split(" ")) 
				{
					inputB.add(Integer.parseInt(i));
				}
				outputMerge.appendText("Second Integer Array Taken\n");
				merger.setArray2(inputB);
			}
		});
		startMerge.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String result = merger.startMerge();
				outputMerge.appendText(result + "\n");
				inputA.clear();
				inputB.clear();
				merger.flushAll();
			}
		});
		toBeSorted.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] stringArray = toBeSorted.getText().split(" ");
				int[] intArray = new int[stringArray.length];
				for(int i = 0; i < stringArray.length; i++) 
				{
					intArray[i] = Integer.parseInt(stringArray[i]);
				}
				sorter.setoutputArray(intArray);
				outputSort.appendText("Integer array taken\n");
			}});
		sortOptionSelect.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				sortType = sortOptionSelect.getValue().toString();
				outputSort.appendText("Sort type " + sortOptionSelect.getValue().toString() + " selected\n");
			}});
		startSort.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				if(sortType == "Bubble sort") 
				{
					for(int i : sorter.bubbleSort()) 
					{
						outputSort.appendText(i + " ");
					}
					outputSort.appendText("\n");
				} else if(sortType == "Insertion sort") 
				{
					for(int i : sorter.insertSort()) 
					{
						outputSort.appendText(i + " ");
					}
					outputSort.appendText("\n");
					} else 
				{
					outputSort.appendText("Please select a sort type before running.\n");
				}
			}});
	}
	
	//Generate content for the three tabs
	private Pane linearSearchPane() 
	{
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(12);
		
		ColumnConstraints columnLeft = new ColumnConstraints();
		columnLeft.setHalignment(HPos.LEFT);
		grid.getColumnConstraints().add(columnLeft);
		
		ColumnConstraints columnRight = new ColumnConstraints();
		columnRight.setHalignment(HPos.RIGHT);
		grid.getColumnConstraints().add(columnRight);
		
		in = new Label("Input numbers here:");
		out = new Label("Results output here:");
		start = new Button("START");
		input = new TextField();
		input.setPromptText("Enter Integer Array");
		key = new TextField();
		key.setPromptText("Enter Search Parameters");
		output = new TextArea();
		output.setEditable(false);
		
		grid.add(in,0,0);
		grid.add(out, 2, 0);
		grid.add(start,1,3);
		grid.add(input,0,1);
		grid.add(key,0,2);
		grid.add(output,2,1,2,2);
		
		return grid;
	}
	private Pane mergePane() 
	{
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(12);
		
		ColumnConstraints columnLeft = new ColumnConstraints();
		columnLeft.setHalignment(HPos.LEFT);
		grid.getColumnConstraints().add(columnLeft);
		
		ColumnConstraints columnRight = new ColumnConstraints();
		columnRight.setHalignment(HPos.RIGHT);
		grid.getColumnConstraints().add(columnRight);
		
		intArray1 = new TextField();
		intArray1.setPromptText("Enter the First Integer Array Here");
		intArray1.setPrefSize(200, 10);
		intArray2 = new TextField();
		intArray2.setPromptText("Enter the Second Integer Array Here");
		startMerge = new Button("Begin Merge");

		outputMerge = new TextArea();
		outputMerge.setEditable(false);
		
		grid.add(intArray1,0,0,2,1);
		grid.add(intArray2,0,1,2,1);
		grid.add(startMerge,2,1);
		grid.add(outputMerge,0,2,3,2);
		return grid;
	}
	private Pane sortPane() 
	{
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(12);
		
		ColumnConstraints columnLeft = new ColumnConstraints();
		columnLeft.setHalignment(HPos.LEFT);
		grid.getColumnConstraints().add(columnLeft);
		
		ColumnConstraints columnRight = new ColumnConstraints();
		columnRight.setHalignment(HPos.RIGHT);
		grid.getColumnConstraints().add(columnRight);
		
		toBeSorted = new TextField();
		toBeSorted.setPromptText("Enter unsorted integer array delimited by space");
		toBeSorted.setPrefWidth(200);
		
		sortOptionSelect = new ComboBox(sortOptions);
		
		startSort = new Button("Start");
		
		outputSort = new TextArea();
		outputSort.setEditable(false);
		outputSort.setPrefWidth(300);
		
		grid.add(toBeSorted, 0, 0,2,1);
		grid.add(sortOptionSelect,0,1);
		grid.add(startSort,0,2);
		grid.add(outputSort,2,0,1,3);
		
		return grid;
	}

}
