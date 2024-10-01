package skillbuilders;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LatinPlantNames {

    private JFrame frame;
    private JLabel plantLabel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LatinPlantNames window = new LatinPlantNames();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public LatinPlantNames() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 300, 200); // Small window size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Panel to hold the dropdown and label
        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 260, 130);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        // Create a dropdown for selecting plants
        String[] plants = {"Basil", "Lavender", "Parsley", "Peppermint", "Saffron", "Sage"};
        JComboBox<String> plantDropdown = new JComboBox<>(plants);
        plantDropdown.setBounds(30, 20, 200, 30);
        panel.add(plantDropdown);

        // Label to display the selected plant name
        plantLabel = new JLabel("Select a plant");
        plantLabel.setBounds(30, 70, 200, 30);
        panel.add(plantLabel);

        // Action listener for the dropdown
        plantDropdown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected plant name
                String selectedPlant = (String) plantDropdown.getSelectedItem();
                
                // Set label text based on the selected plant name
                if (selectedPlant.equals("Basil")) {
                    plantLabel.setText("Basil = Ocimum");
                } else if (selectedPlant.equals("Lavender")) {
                    plantLabel.setText("Lavender = Lavendula spica");
                } else if (selectedPlant.equals("Parsley")) {
                    plantLabel.setText("Parsley = Apium");
                } else if (selectedPlant.equals("Peppermint")) {
                    plantLabel.setText("Peppermint = Mentha piperita");
                } else if (selectedPlant.equals("Saffron")) {
                    plantLabel.setText("Saffron = Crocus");
                } else if (selectedPlant.equals("Sage")) {
                    plantLabel.setText("Sage = Salvia");
                }
            }
        });
    }
}
