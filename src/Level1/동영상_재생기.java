package Level1;

import java.time.format.DateTimeFormatter;
import java.time.LocalTime;

public class 동영상_재생기 {
    private LocalTime videoTime;
    private LocalTime posTime;
    private LocalTime opStartTime;
    private LocalTime opEndTime;

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        videoTime = parseTime(video_len);
        posTime = parseTime(pos);
        opStartTime = parseTime(op_start);
        opEndTime = parseTime(op_end);

        skip();

        for (String command : commands) {
            if (command.equals("next")) {
                next();
            } else {
                prev();
            }
            skip();
        }
        return posTime.format(DateTimeFormatter.ofPattern("mm:ss"));
    }
    private void skip(){
        if (!posTime.isBefore(opStartTime) && !posTime.isAfter(opEndTime))
            posTime = opEndTime;
    }
    private void prev() {
        posTime = posTime.minusSeconds(10);

        if (posTime.isBefore(LocalTime.of(0, 0))) {
            posTime = LocalTime.of(0, 0);
        }
    }
    private void next() {
        posTime = posTime.plusSeconds(10);

        if (posTime.isAfter(videoTime)) {
            posTime = videoTime;
        }
    }
    private LocalTime parseTime(String time) {
        String[] temp = time.split(":");
        int minutes = Integer.parseInt(temp[0]);
        int seconds = Integer.parseInt(temp[1]);
        return LocalTime.of(0, minutes, seconds);
    }
}
