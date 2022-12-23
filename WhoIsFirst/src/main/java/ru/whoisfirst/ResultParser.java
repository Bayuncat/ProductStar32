package ru.whoisfirst;

import java.time.Duration;
import org.springframework.stereotype.Service;

import static java.lang.Integer.parseInt;

@Service
public class ResultParser {

    private static final String SEPARATOR = ",";

    public Result parseResult(String line) {
        var resultParts = line.split(SEPARATOR);

        var name = resultParts[0];
        var gender = Gender.of(resultParts[1]);
        var distance = Distance.of(resultParts[2]);
        var time = parseTime(resultParts[3]);

        var person = new Person(name, gender);
        return new Result(person, distance, time);
    }

    /**
     * ���������� ������ MM:SS � {@link Duration}.
     * </p>
     * ������������, ��� ��� ���������� ��������� � ���� ��� � ����� ��������� ��������.
     */
    private Duration parseTime(String time) {
        var timeParts = time.split(":");

        // ������ ��������� �� 60 � ��������� �������
        var totalSecond = parseInt(timeParts[0]) * 60 + parseInt(timeParts[1]);
        return Duration.ofSeconds(totalSecond);
    }
}