import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name) {
        String guestGreeting = String.format("Hello, %s. Lovely to see you.", name);
        return guestGreeting;
    }

    public String dateAnnouncement() {
        Date date = new Date();
        return "It is currently " + date;
    }

    public String respondBeforeAlexis(String conversation) {
        int a = conversation.indexOf("Alexis");
        int b = conversation.indexOf("Alfred");
        if(a > b) {
            String response = "Right away, sir. She certainly isn't sophisticated enough for that.";
            return response;
        }
        else if(b > a) {
            String response = "At your service. As you wish, naturally.";
            return response;
        }
        else {
            String response = "Right. And with that I shall retire.";
            return response;
        }
    }
}
