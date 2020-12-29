package jcr.designPatterns.structural;

public class AdaptorPattern {
    public static void main(String[] args) {
        VlcPlayer player = new Mp3Player();
        player.play("file.mp3");

        player = new FormatAdapter(new Mp4Player());
        player.play("file.mp4");
    }

    private interface VlcPlayer {
        void play(String file);
    }

    private static class Mp3Player implements VlcPlayer {
        public void play(String file) {
            System.out.println("Playing Mp3");
        }
    }

    private static class FormatAdapter implements VlcPlayer {

        MediaPlayer mediaPlayer;

        FormatAdapter(MediaPlayer supportedFormat) {
            this.mediaPlayer = supportedFormat;
        }

        public void play(String file) {
            this.mediaPlayer.playFile(file);
        }
    }
    // ============================================================================
    private interface MediaPlayer {
        void playFile(String file);
    }

    private static class Mp4Player implements MediaPlayer {
        public void playFile(String file) {
            System.out.println("Playing Mp4");
        }
    }
}
