package controllers;

import client.Client;
import common.Query;
import common.User;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class MyProfileController {

    public Label name;
    public Label gender;
    public Label dateofbirth;
    public Label region;
    public Label email;

    public CheckBox change_password;
    public CheckBox visible_password;

    private boolean mask = true;
    public PasswordField password;
    public TextField unmasked_password;
    public PasswordField repeat_password;
    public TextField unmasked_repeat_password;

    public Label message;

    public VBox vbox;

    public void change_password() {
        vbox.setDisable(!vbox.isDisable());
    }

    public void visible_password() {
        if (mask) {
            unmasked_password.setText(password.getText());
            unmasked_repeat_password.setText(repeat_password.getText());
        } else {
            password.setText(unmasked_password.getText());
            repeat_password.setText(unmasked_repeat_password.getText());
        }
        password.setVisible(!mask);
        unmasked_password.setVisible(mask);
        repeat_password.setVisible(!mask);
        unmasked_repeat_password.setVisible(mask);
        mask = !mask;
    }

    public void save() {
        String pw1 = mask ? password.getText() : unmasked_password.getText();
        String pw2 = mask ? repeat_password.getText() : unmasked_repeat_password.getText();

        if (!pw1.equals(pw2))
            message.setText("Пароли не совпадают");
        else if (pw1.length() < 6 || pw1.length() > 16)
            message.setText("Должно быть не менее 6 символов и не более 16 символов");
        else if (!pw1.matches(".*\\d.*"))
            message.setText("Должно быть не менее 1 цифры");
        else if (!pw1.matches(".*[a-zа-яё].*"))
            message.setText("Должно быть не менее 1 строчной буквы");
        else if (!pw1.matches(".*[A-ZА-ЯЁ].*"))
            message.setText("Должно быть не менее 1 прописной буквы");
        else if (pw1.matches(".* .*"))
            message.setText("Не должен быть пробел");
        else {
            for (var i = 0; i < pw1.length() - 2; ++i)
                if (pw1.charAt(i) == pw1.charAt(i + 1) && pw1.charAt(i + 1) == pw1.charAt(i + 2)) {
                    message.setText("Не должно быть три одинаковых символа подряд");
                    return;
                }
            message.setText("");
        }
        if (message.getText().length() > 0)
            return;

        Client.request(Query.createCHANGE_PASSWORD(User.user.email, pw1));
        onShown();
    }

    public void cancel() {
        password.setText("");
        unmasked_password.setText("");
        repeat_password.setText("");
        unmasked_repeat_password.setText("");
        message.setText("");
    }

    public void onShown() {
        cancel();
        change_password.setSelected(false);
        visible_password.setSelected(false);

        mask = true;
        password.setVisible(true);
        unmasked_password.setVisible(false);
        repeat_password.setVisible(true);
        unmasked_repeat_password.setVisible(false);

        vbox.setDisable(true);
    }
}