import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bot extends TelegramLongPollingBot {

    public InlineKeyboardButton sendForStartTest = InlineKeyboardButton.builder()
            .text("Send for start test")
            .callbackData("send for start test")
            .build();
    public InlineKeyboardButton oneCity = InlineKeyboardButton.builder()
            .text("Марсель")
            .callbackData("марсель")
            .build();
    public InlineKeyboardButton secondCity = InlineKeyboardButton.builder()
            .text("Канны")
            .callbackData("канны")
            .build();
    public InlineKeyboardButton thirdCity = InlineKeyboardButton.builder()
            .text("Париж")
            .callbackData("париж")
            .build();
    public InlineKeyboardButton fourthCity = InlineKeyboardButton.builder()
            .text("Москва")
            .callbackData("москва")
            .build();
    private InlineKeyboardMarkup keyboardM1 = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(sendForStartTest))
            .build();
    private InlineKeyboardMarkup sendQuestionOne = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(oneCity))
            .keyboardRow(List.of(secondCity))
            .keyboardRow(List.of(thirdCity))
            .keyboardRow(List.of(fourthCity))
            .build();

    public InlineKeyboardButton firstPlace = InlineKeyboardButton.builder()
            .text("В Белом доме")
            .callbackData("в Белом доме")
            .build();
    public InlineKeyboardButton secondPlace = InlineKeyboardButton.builder()
            .text("На Красной площади")
            .callbackData("на Красной площади")
            .build();
    public InlineKeyboardButton thirdPlace = InlineKeyboardButton.builder()
            .text("В Таймс - Сквере")
            .callbackData("в Таймс - Сквере")
            .build();
    public InlineKeyboardButton fourthPlace = InlineKeyboardButton.builder()
            .text("В Брантенбурской площади")
            .callbackData("в Брантенбурской площади")
            .build();
    private InlineKeyboardMarkup sendQuestionTwo = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(firstPlace))
            .keyboardRow(List.of(secondPlace))
            .keyboardRow(List.of(thirdPlace))
            .keyboardRow(List.of(fourthPlace))
            .build();

    public InlineKeyboardButton firstCountry = InlineKeyboardButton.builder()
            .text("Молдовия")
            .callbackData("молдовия")
            .build();
    public InlineKeyboardButton secondCountry = InlineKeyboardButton.builder()
            .text("Украина")
            .callbackData("украина")
            .build();
    public InlineKeyboardButton thirdCountry = InlineKeyboardButton.builder()
            .text("Канада")
            .callbackData("канада")
            .build();
    public InlineKeyboardButton fourthCountry = InlineKeyboardButton.builder()
            .text("Великобритания")
            .callbackData("великобритания")
            .build();
    private InlineKeyboardMarkup sendQuestionThree = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(firstCountry))
            .keyboardRow(List.of(secondCountry))
            .keyboardRow(List.of(thirdCountry))
            .keyboardRow(List.of(fourthCountry))
            .build();

    @Override
    public String getBotUsername() {
        return "@questions_alex_bot";
    }

    @Override
    public String getBotToken() {
        return "6826798360:AAHpigNRXgDFm1OOs46C9nFAYKGEFFn1yts";
    }

    @Override
    public void onUpdateReceived(Update update) {
        buttonTab(update);
        isCommand(update.getMessage());
    }
    public void isCommand(Message message) {
        String text = message.getText();
        if (text.equals("/start_test")) {
            System.out.println("User \"" + message.getFrom().getFirstName() + "\" added!");
            sendMenu(message.getFrom().getId(), "<b>Go to the start test</b>", keyboardM1);
        }
    }
    public void sendMenu(Long who, String txt, InlineKeyboardMarkup km) {
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString())
                .parseMode("HTML")
                .text(txt)
                .replyMarkup(km)
                .build();

        try {
            execute(sm);
        } catch (TelegramApiException tae) {
            throw new RuntimeException(tae);
        }
    }
    public void buttonTab(Update update) {
        if (update.hasCallbackQuery()) {
            String idUser = update.getCallbackQuery().getMessage().getChatId().toString();
            int idMessage = update.getCallbackQuery().getMessage().getMessageId();
            String data = update.getCallbackQuery().getData();
            String queryId = update.getCallbackQuery().getId();

            EditMessageText editMessageText = EditMessageText.builder()
                    .chatId(idUser)
                    .messageId(idMessage)
                    .text("")
                    .build();

            EditMessageReplyMarkup editMessageReplyMarkup = EditMessageReplyMarkup.builder()
                    .chatId(idUser.toString())
                    .messageId(idMessage)
                    .build();


            if (data.equals("send for start test")) {
                editMessageText.setText("Какая столица Франции?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionOne);
            }
            else if(data.equals("париж")){
                editMessageText.setText("Где собираются сенаторы США");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwo);
            }
            else if(data.equals("москва")){
                editMessageText.setText("Где собираются сенаторы США");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwo);
            }
            else if(data.equals("канны")){
                editMessageText.setText("Где собираются сенаторы США");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwo);
            }
            else if(data.equals("марсель")){
                editMessageText.setText("Где собираются сенаторы США");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwo);
            }
            else if(data.equals("в Белом доме")){
                editMessageText.setText("какая страна производит больше нефти?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionThree);
            }

            AnswerCallbackQuery answerCallbackQuery = AnswerCallbackQuery.builder()
                    .callbackQueryId(queryId)
                    .build();

            try {
                execute(answerCallbackQuery);
                execute(editMessageText);
                execute(editMessageReplyMarkup);
            } catch (Exception ex) {
                ex.getMessage();
            }
        }
    }

}
