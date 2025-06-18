import java.util.UUID;

public class Message {
    private String messageID;
    private String recipient;
    private String content;
    private String messageHash;

    public Message(String recipient, String content) {
        this.recipient = recipient;
        this.content = content;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }

    private String generateMessageID() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
    }

    public static boolean checkRecipientCell(String number) {
        return number != null && number.matches("^\\+27\\d{9}$");
    }

    public boolean checkMessageLength() {
        return content.length() <= 250;
    }

    public String createMessageHash() {
        String[] words = content.trim().split("\\s+");
        String firstWord = words.length > 0 ? words[0].toUpperCase() : "";
        String lastWord = words.length > 1 ? words[words.length - 1].toUpperCase() : firstWord;
        return messageID.substring(0, 2) + ":" + firstWord + lastWord;
    }

    public String getMessageID() {
        return messageID;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getContent() {
        return content;
    }

    public String getMessageHash() {
        return messageHash;
    }
}
