public class Login {
    private User user;

    public Login(User user) { this.user = user; }

    public boolean checkUserName() {
        return user.getUsername().contains("_") && user.getUsername().length() <= 5;
    }

    public boolean checkPasswordComplexity() {
        String pwd = user.getPassword();
        return pwd.length() >= 8 && pwd.matches(".*[A-Z].*") && pwd.matches(".*[0-9].*") && pwd.matches(".*[!@#$%^&*()].*");
    }

    public boolean checkCellPhoneNumber() {
        return user.getCellNumber().matches("^\\+27\\d{9}$");
    }

    public String register() {
        if (!checkUserName()) return "Username is incorrect...";
        if (!checkPasswordComplexity()) return "Password is not correctly formatted...";
        if (!checkCellPhoneNumber()) return "Cell phone number incorrectly formatted...";
        return "REGISTRATION SUCCESSFUL";
    }

    public boolean authenticate(String u, String p) {
        return user.getUsername().equals(u) && user.getPassword().equals(p);
    }

    public String getLoginMessage(String u, String p) {
        if (authenticate(u, p)) {
            return "Successful login. Welcome, " + user.getFirstName() + " " + user.getLastName() + "!";
        } else {
            return "Login failed. Username or password incorrect.";
        }
    }
}
