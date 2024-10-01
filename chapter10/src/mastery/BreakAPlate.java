package mastery;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Random;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class BreakAPlate {

    private JFrame frame;
    private JLabel imgLabel, prizeLabel;
    private JButton playButton;
    private boolean isGameOver;

    // Paths to the images
    private final String plateImg = "C:\\Users\\38020001\\git\\CS30P3F2024\\chapter10\\src\\breakAPlate_img\\plates.png";
    private final String platesAllBrokenImg = "C:\\Users\\38020001\\git\\CS30P3F2024\\chapter10\\src\\breakAPlate_img\\plates_all_broken.png";
    private final String platesTwoBrokenImg = "C:\\Users\\38020001\\git\\CS30P3F2024\\chapter10\\src\\breakAPlate_img\\plates_two_broken.png";
    private final String tigerPlushImg = "C:\\Users\\38020001\\git\\CS30P3F2024\\chapter10\\src\\breakAPlate_img\\tiger_plush.png";
    private final String stickerImg = "C:\\Users\\38020001\\git\\CS30P3F2024\\chapter10\\src\\breakAPlate_img\\sticker.png";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                BreakAPlate window = new BreakAPlate();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public BreakAPlate() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 400, 450); // Frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        // Image of the plates at the top
        imgLabel = new JLabel(new ImageIcon(plateImg), SwingConstants.CENTER);
        frame.getContentPane().add(imgLabel, BorderLayout.NORTH);

        // Play button and prize section in the center
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(null);

        // Play button in the center, smaller in size
        playButton = new JButton("Play");
        playButton.setBounds(74, 34, 245, 73);
        playButton.setPreferredSize(new Dimension(100, 30)); // Smaller button size
        centerPanel.add(playButton);

        // Prize label at the bottom of the button
        prizeLabel = new JLabel("", SwingConstants.CENTER);
        prizeLabel.setBounds(0, 130, 384, 50);
        prizeLabel.setPreferredSize(new Dimension(300, 50)); // Set space for prize
        centerPanel.add(prizeLabel);

        frame.getContentPane().add(centerPanel, BorderLayout.CENTER);

        // Add action listener to the play button
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isGameOver) {
                    resetGame();
                } else {
                    playGame();
                }
            }
        });

        isGameOver = false;
    }

    /**
     * Handles the logic for playing the game.
     */
    private void playGame() {
        Random rand = new Random();
        int plate1 = rand.nextInt(2); // 0 or 1
        int plate2 = rand.nextInt(2); // 0 or 1
        int plate3 = rand.nextInt(2); // 0 or 1

        int brokenPlates = plate1 + plate2 + plate3; // Sum of broken plates

        if (brokenPlates == 3) {
            imgLabel.setIcon(new ImageIcon(platesAllBrokenImg));
            prizeLabel.setText("Congratulations! You won a Tiger Plush!");
            prizeLabel.setIcon(new ImageIcon(tigerPlushImg));
        } else {
            imgLabel.setIcon(new ImageIcon(platesTwoBrokenImg));
            prizeLabel.setText("You won a sticker consolation prize.");
            prizeLabel.setIcon(new ImageIcon(stickerImg));
        }

        playButton.setText("Play Again");
        isGameOver = true;
    }

    /**
     * Resets the game to its initial state.
     */
    private void resetGame() {
        imgLabel.setIcon(new ImageIcon(plateImg));
        prizeLabel.setText("");
        prizeLabel.setIcon(null);
        playButton.setText("Play");
        isGameOver = false;
    }
}
