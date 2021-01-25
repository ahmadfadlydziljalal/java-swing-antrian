/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.telegram;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

/**
 *
 * @author Ahmad Fadly Dzil Jalal <ahmadfadlydziljalal@gmail.com>
 */
public class MyTelegram {

    public static void sendMesssage(String message) {
        String chatId = "-156635449";
        String botToken = "714635157:AAFI2AnOf0NflpI--KI_q7lKN7etes5gq-g";

        SendMessage sendMessage;
        sendMessage = new SendMessage(chatId, message);

        TelegramBot bot = new TelegramBot(botToken);
        SendResponse response = bot.execute(sendMessage);
    }
}
