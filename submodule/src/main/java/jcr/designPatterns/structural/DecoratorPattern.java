package jcr.designPatterns.structural;

public class DecoratorPattern {
    public static void main(String[] args) {
        EmailSender.send(new Email("Rahul", "abc.impressico.com"));
    }

    private static interface EmailInterface {
        String getContent();

        String getTo();
    }

    private static class Email implements EmailInterface {
        private String content;
        private String to;

        Email(String content, String to) {
            this.content = content;
            this.to = to;
        }

        public String getContent() {
            return content;
        }

        public String getTo() {
            return to;
        }
    }

    private abstract static class AbstractEmailDecorator implements EmailInterface {
        EmailInterface emailInterface;

        @Override
        public String getTo() {
            return emailInterface.getTo();
        }
    }

    private static class ExternalEmailDecorator extends AbstractEmailDecorator {
        ExternalEmailDecorator(EmailInterface emailInterface) {
            this.emailInterface = emailInterface;
        }

        public String getContent() {
            return emailInterface.getContent() + " \n Disclaimer: message";
        }
    }

    private static class EmailSender {
        public static void send(EmailInterface emailInterface) {
            if (emailInterface.getTo().contains("impressico.com")) {
                System.out.println(
                        "Sent: " + new ExternalEmailDecorator(emailInterface).getContent());
            }
        }
    }
}
