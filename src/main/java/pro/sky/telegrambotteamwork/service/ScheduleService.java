package pro.sky.telegrambotteamwork.service;

import com.pengrad.telegrambot.TelegramBot;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pro.sky.telegrambotteamwork.repository.ReportDataRepository;

@Service
@AllArgsConstructor
@EnableScheduling
@ConditionalOnProperty(name = "scheduler.enabled", matchIfMissing = true)
public class ScheduleService {

    private final ReportDataRepository reportDataRepository;
    private final TelegramBot telegramBot;


//    @Scheduled(cron = "0 0 21 * * *")
//    public void checkingScheduleReports() {
//        if (daysOfReportData < 30) {
//        var twoDay = 172800000;
//            var nowTime = new reportDate().getTime() - twoDay;
//            var getDistinct = reportDataRepository.findAll().stream()
//                    .sorted(Comparator.comparing(ReportData::getChatId))
//                    .max(Comparator.comparing(ReportData::getLastMessageMs));
//            getDistinct.stream()
//            .filter(i -> i.getLastMessageMs() * 1000 < nowTime)
//                    .forEach(s -> sendMessage(s.getChatId(), "Вы забыли прислать отчет"));    }
//    }
}
