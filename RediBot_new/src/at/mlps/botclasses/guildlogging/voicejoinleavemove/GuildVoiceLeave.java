package at.mlps.botclasses.guildlogging.voicejoinleavemove;

import java.text.SimpleDateFormat;
import java.util.Date;

import at.mlps.botclasses.guildlogging.guild.GuildLogEvents;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildVoiceLeave extends ListenerAdapter{
	
	public void onGuildVoiceLeave(GuildVoiceLeaveEvent e) {
		Guild g = e.getGuild();
		GuildLogEvents gl = new GuildLogEvents();
		SimpleDateFormat time = new SimpleDateFormat("dd/MM/yy - HH:mm:ss");
        String stime = time.format(new Date());
        EmbedBuilder eb = new EmbedBuilder();
    	eb.setTitle("Member has left a voicechannel.");
    	eb.setDescription("Member: " + e.getMember().getAsMention() + "\nChannel: " + e.getChannelLeft().getName());
    	eb.setFooter(stime);
		eb.setColor(gl.green);
		if(gl.enabledLog(g, "guildvoiceleave")) {
			gl.sendMsg(eb, g);
		}
	}

}
