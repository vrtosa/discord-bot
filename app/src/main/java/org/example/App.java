import net.dv8tion.jda.api.EmbedBuilder;
import java.awt.Color;

@Override
public void onGuildMemberJoin(GuildMemberJoinEvent event) {
    event.getGuild()
            .getTextChannelsByName("welcome", true)
            .stream()
            .findFirst()
            .ifPresent(channel -> {

                EmbedBuilder embed = new EmbedBuilder();

                embed.setColor(new Color(180, 0, 255)); // purple sidebar

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

                embed.setThumbnail(event.getUser().getEffectiveAvatarUrl()); // user avatar

                embed.setImage("YOUR_BANNER_URL_HERE"); // optional banner

                embed.setFooter("Tempest Federation • Community & Vibes");

                channel.sendMessage("Welcome " + event.getUser().getAsMention() + " 👋")
                        .setEmbeds(embed.build())
                        .queue();
            });
}