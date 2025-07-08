import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ZodiacGUI extends JFrame {

    private JTextField nameField;
    private JComboBox<String> genderBox;
    private JTextField birthDateField;
    private JButton calculateButton;
    private JTextArea resultArea;

    public ZodiacGUI() {
        setTitle("Zodiac Sign Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        // Giriş alanları
        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Gender (M/F):"));
        genderBox = new JComboBox<>(new String[] { "M", "F" });
        panel.add(genderBox);

        panel.add(new JLabel("Date of Birth (dd/mm/yyyy):"));
        birthDateField = new JTextField();
        panel.add(birthDateField);

        calculateButton = new JButton("Calculate Zodiac Sign");
        panel.add(calculateButton);

        resultArea = new JTextArea();
        resultArea.setFont(new Font("Arial", Font.PLAIN, 10)); //

        resultArea.setEditable(false);
        panel.add(resultArea);

        add(panel);

        calculateButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String genderInput = genderBox.getSelectedItem().toString();
            String gender = genderInput.equalsIgnoreCase("M") ? "Male" : "Female";
            String birthDate = birthDateField.getText().trim();

            try {
                String[] parts = birthDate.split("/");
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);

                String zodiac = calculateZodiac(day, month);

                resultArea.setText(
                        "Name: " + name + "\n" +
                                "Gender: " + gender + "\n" +
                                "Date of Birth: " + birthDate + "\n" +
                                "Your Zodiac Sign: " + zodiac
                );
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid date in dd/mm/yyyy format.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    // Orijinal method korunarak eklendi
    public static String calculateZodiac(int day, int month) {
        switch (month) {
            case 1:
                return (day < 20) ? "Capricorn" : "Aquarius";
            case 2:
                return (day < 19) ? "Aquarius" : "Pisces";
            case 3:
                return (day < 21) ? "Pisces" : "Aries";
            case 4:
                return (day < 20) ? "Aries" : "Taurus";
            case 5:
                return (day < 21) ? "Taurus" : "Gemini";
            case 6:
                return (day < 21) ? "Gemini" : "Cancer";
            case 7:
                return (day < 23) ? "Cancer" : "Leo";
            case 8:
                return (day < 23) ? "Leo" : "Virgo";
            case 9:
                return (day < 23) ? "Virgo" : "Libra";
            case 10:
                return (day < 23) ? "Libra" : "Scorpio";
            case 11:
                return (day < 22) ? "Scorpio" : "Sagittarius";
            case 12:
                return (day < 22) ? "Sagittarius" : "Capricorn";
            default:
                return "Invalid date!";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ZodiacGUI gui = new ZodiacGUI();
            gui.setVisible(true);
        });
    }
}
