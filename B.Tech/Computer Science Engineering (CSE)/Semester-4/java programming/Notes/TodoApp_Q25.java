/**
 * TodoApp_Q25.java
 * 
 * This program implements a simple To-Do application using JavaFX.
 * It allows users to add, edit, delete, and mark tasks as completed.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.time.LocalDate;

public class TodoApp_Q25 extends Application {
    
    // Model: Task class to represent a to-do item
    private static class Task {
        private final String description;
        private final LocalDate dueDate;
        private boolean completed;
        
        public Task(String description, LocalDate dueDate) {
            this.description = description;
            this.dueDate = dueDate;
            this.completed = false;
        }
        
        public String getDescription() {
            return description;
        }
        
        public LocalDate getDueDate() {
            return dueDate;
        }
        
        public boolean isCompleted() {
            return completed;
        }
        
        public void setCompleted(boolean completed) {
            this.completed = completed;
        }
        
        @Override
        public String toString() {
            return description + " (Due: " + dueDate + ")";
        }
    }
    
    // Data model: list of tasks
    private final ObservableList<Task> taskList = FXCollections.observableArrayList();
    
    // UI components
    private ListView<Task> taskListView;
    private TextField taskDescriptionField;
    private DatePicker dueDatePicker;
    
    @Override
    public void start(Stage primaryStage) {
        // Set up the primary stage
        primaryStage.setTitle("To-Do Application");
        
        // Create the main layout
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        
        // Create the task input form
        GridPane inputForm = createInputForm_Q25();
        root.setTop(inputForm);
        
        // Create the task list view
        taskListView = new ListView<>(taskList);
        taskListView.setCellFactory(createCellFactory_Q25());
        root.setCenter(taskListView);
        
        // Create the button panel
        HBox buttonPanel = createButtonPanel_Q25();
        root.setBottom(buttonPanel);
        
        // Create the scene and show the stage
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Add some sample tasks
        addSampleTasks_Q25();
    }
    
    private GridPane createInputForm_Q25() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 0, 10, 0));
        
        // Task description input
        Label descriptionLabel = new Label("Task Description:");
        taskDescriptionField = new TextField();
        taskDescriptionField.setPromptText("Enter task description");
        
        // Due date input
        Label dueDateLabel = new Label("Due Date:");
        dueDatePicker = new DatePicker();
        dueDatePicker.setValue(LocalDate.now());
        
        // Add button
        Button addButton = new Button("Add Task");
        addButton.setOnAction(e -> addTask_Q25());
        
        // Add components to the grid
        grid.add(descriptionLabel, 0, 0);
        grid.add(taskDescriptionField, 1, 0);
        grid.add(dueDateLabel, 0, 1);
        grid.add(dueDatePicker, 1, 1);
        grid.add(addButton, 1, 2);
        
        // Set column constraints
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(30);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(70);
        grid.getColumnConstraints().addAll(col1, col2);
        
        return grid;
    }
    
    private HBox createButtonPanel_Q25() {
        HBox buttonPanel = new HBox(10);
        buttonPanel.setPadding(new Insets(10, 0, 0, 0));
        
        Button deleteButton = new Button("Delete Task");
        deleteButton.setOnAction(e -> deleteTask_Q25());
        
        Button markCompletedButton = new Button("Mark as Completed");
        markCompletedButton.setOnAction(e -> markTaskAsCompleted_Q25());
        
        Button clearAllButton = new Button("Clear All");
        clearAllButton.setOnAction(e -> clearAllTasks_Q25());
        
        buttonPanel.getChildren().addAll(deleteButton, markCompletedButton, clearAllButton);
        
        return buttonPanel;
    }
    
    private Callback<ListView<Task>, ListCell<Task>> createCellFactory_Q25() {
        return listView -> new ListCell<Task>() {
            @Override
            protected void updateItem(Task task, boolean empty) {
                super.updateItem(task, empty);
                
                if (empty || task == null) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(task.getDescription() + " (Due: " + task.getDueDate() + ")");
                    
                    // Apply different styles based on task status
                    if (task.isCompleted()) {
                        setStyle("-fx-text-fill: gray; -fx-strikethrough: true;");
                    } else if (task.getDueDate().isBefore(LocalDate.now())) {
                        setStyle("-fx-text-fill: red;"); // Overdue tasks
                    } else if (task.getDueDate().equals(LocalDate.now())) {
                        setStyle("-fx-text-fill: orange;"); // Due today
                    } else {
                        setStyle("");
                    }
                }
            }
        };
    }
    
    private void addTask_Q25() {
        String description = taskDescriptionField.getText().trim();
        LocalDate dueDate = dueDatePicker.getValue();
        
        if (!description.isEmpty() && dueDate != null) {
            Task newTask = new Task(description, dueDate);
            taskList.add(newTask);
            
            // Clear the input fields
            taskDescriptionField.clear();
            dueDatePicker.setValue(LocalDate.now());
            taskDescriptionField.requestFocus();
        } else {
            showAlert_Q25("Invalid Input", "Please enter a task description and select a due date.");
        }
    }
    
    private void deleteTask_Q25() {
        int selectedIndex = taskListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            taskList.remove(selectedIndex);
        } else {
            showAlert_Q25("No Selection", "Please select a task to delete.");
        }
    }
    
    private void markTaskAsCompleted_Q25() {
        int selectedIndex = taskListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Task selectedTask = taskList.get(selectedIndex);
            selectedTask.setCompleted(!selectedTask.isCompleted()); // Toggle completed status
            
            // Refresh the list view to update the display
            taskListView.refresh();
        } else {
            showAlert_Q25("No Selection", "Please select a task to mark as completed.");
        }
    }
    
    private void clearAllTasks_Q25() {
        taskList.clear();
    }
    
    private void addSampleTasks_Q25() {
        taskList.add(new Task("Complete Java assignment", LocalDate.now().plusDays(1)));
        taskList.add(new Task("Prepare presentation", LocalDate.now().plusDays(3)));
        taskList.add(new Task("Study for exam", LocalDate.now().plusDays(7)));
    }
    
    private void showAlert_Q25(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
} 