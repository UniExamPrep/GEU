import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MovieTicketBookingSystem extends Application {
    
    // Movie prices
    private static final double REGULAR_MOVIE_PRICE = 10.0;
    private static final double PREMIUM_MOVIE_PRICE = 15.0;
    
    // UI components
    private ComboBox<String> movieComboBox;
    private ComboBox<String> showtimeComboBox;
    private Spinner<Integer> ticketSpinner;
    private Label totalCostLabel;
    
    @Override
    public void start(Stage primaryStage) {
        // Set the title
        primaryStage.setTitle("Movie Ticket Booking System");
        
        // Create the main grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        // Add title
        Text sceneTitle = new Text("Movie Ticket Booking");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);
        
        // Movie selection
        Label movieLabel = new Label("Select Movie:");
        grid.add(movieLabel, 0, 1);
        
        movieComboBox = new ComboBox<>();
        movieComboBox.getItems().addAll(
            "The Avengers (Regular)",
            "Jurassic World (Regular)",
            "Star Wars (Premium)",
            "The Dark Knight (Premium)"
        );
        movieComboBox.setPromptText("Select a movie");
        movieComboBox.setOnAction(e -> calculateTotal());
        grid.add(movieComboBox, 1, 1);
        
        // Showtime selection
        Label showtimeLabel = new Label("Select Showtime:");
        grid.add(showtimeLabel, 0, 2);
        
        showtimeComboBox = new ComboBox<>();
        showtimeComboBox.getItems().addAll(
            "10:00 AM",
            "1:00 PM",
            "4:00 PM",
            "7:00 PM",
            "10:00 PM"
        );
        showtimeComboBox.setPromptText("Select a showtime");
        grid.add(showtimeComboBox, 1, 2);
        
        // Number of tickets
        Label ticketsLabel = new Label("Number of Tickets:");
        grid.add(ticketsLabel, 0, 3);
        
        ticketSpinner = new Spinner<>(1, 10, 1);
        ticketSpinner.setEditable(true);
        ticketSpinner.valueProperty().addListener((obs, oldValue, newValue) -> calculateTotal());
        grid.add(ticketSpinner, 1, 3);
        
        // Total cost
        Label costLabel = new Label("Total Cost:");
        grid.add(costLabel, 0, 4);
        
        totalCostLabel = new Label("$0.00");
        grid.add(totalCostLabel, 1, 4);
        
        // Button box
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        
        Button confirmButton = new Button("Confirm Booking");
        confirmButton.setOnAction(e -> confirmBooking());
        
        Button resetButton = new Button("Reset");
        resetButton.setOnAction(e -> resetForm());
        
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> primaryStage.close());
        
        buttonBox.getChildren().addAll(confirmButton, resetButton, exitButton);
        grid.add(buttonBox, 0, 5, 2, 1);
        
        // Create scene and show
        Scene scene = new Scene(grid, 400, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    // Calculate the total cost
    private void calculateTotal() {
        if (movieComboBox.getValue() == null) {
            return;
        }
        
        double price = 0.0;
        if (movieComboBox.getValue().contains("Regular")) {
            price = REGULAR_MOVIE_PRICE;
        } else if (movieComboBox.getValue().contains("Premium")) {
            price = PREMIUM_MOVIE_PRICE;
        }
        
        int numTickets = ticketSpinner.getValue();
        double total = price * numTickets;
        
        totalCostLabel.setText(String.format("$%.2f", total));
    }
    
    // Confirm booking
    private void confirmBooking() {
        if (movieComboBox.getValue() == null || showtimeComboBox.getValue() == null) {
            showAlert("Error", "Please select a movie and showtime.");
            return;
        }
        
        String movie = movieComboBox.getValue();
        String showtime = showtimeComboBox.getValue();
        int tickets = ticketSpinner.getValue();
        double total = Double.parseDouble(totalCostLabel.getText().substring(1));
        
        String message = String.format(
            "Booking Confirmed!\n\nMovie: %s\nShowtime: %s\nTickets: %d\nTotal Cost: $%.2f",
            movie, showtime, tickets, total
        );
        
        showAlert("Booking Confirmed", message);
    }
    
    // Reset the form
    private void resetForm() {
        movieComboBox.setValue(null);
        showtimeComboBox.setValue(null);
        ticketSpinner.getValueFactory().setValue(1);
        totalCostLabel.setText("$0.00");
    }
    
    // Show an alert
    private void showAlert(String title, String message) {
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