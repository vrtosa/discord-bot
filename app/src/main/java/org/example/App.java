package org.example;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.awt.Color;

public class App extends ListenerAdapter {
    public static void main(String[] args) throws Exception {
        JDABuilder.createDefault(System.getenv("DISCORD_TOKEN"))
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .addEventListeners(new App())
                .build();
    }

@Override
public void onGuildMemberJoin(GuildMemberJoinEvent event) {

    var channel = event.getGuild().getTextChannelById("1492289784448811230");

    if (channel != null) {

        EmbedBuilder embed = new EmbedBuilder();

        embed.setColor(new Color(180, 0, 255));

        embed.setTitle("➤ Welcome To Tempest Federation");

        embed.setDescription(
                "✦ You Just Stepped Into Something New\n\n" +

                "*This isn’t just a server,*\n\n" +

                "✦ It’s a place to hang out, share ideas, and connect with awesome people.\n" +
                "✦ Whether you're here to chat, learn, game, or just vibe — you belong here.\n\n" +

                "✨ **What to do next:**\n" +
                "→ Check the rules\n" +
                "→ Introduce yourself\n" +
                "→ Jump into a conversation\n\n" +

                "🎯 Ask questions or share what you're into\n" +
                "💬 Be respectful and have fun\n\n" +

                "*If you need anything, staff is here to help.*\n\n" +

                "**Enjoy your stay and make yourself at home 🚀**"
        );

        embed.setThumbnail(event.getUser().getEffectiveAvatarUrl());
        embed.setFooter("Tempest Federation • Community & Vibes");

        channel.sendMessage("Welcome " + event.getUser().getAsMention() + " 👋")
                .setEmbeds(embed.build())
                .queue();
    }
}
