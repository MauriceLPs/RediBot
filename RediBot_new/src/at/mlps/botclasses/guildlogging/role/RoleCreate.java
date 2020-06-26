package at.mlps.botclasses.guildlogging.role;

import java.text.SimpleDateFormat;
import java.util.Date;

import at.mlps.botclasses.guildlogging.guild.GuildLogEvents;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.role.RoleCreateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RoleCreate extends ListenerAdapter{
	
	public void onRoleCreate(RoleCreateEvent e) {
		GuildLogEvents gl = new GuildLogEvents();
		Guild g = e.getGuild();
		SimpleDateFormat time = new SimpleDateFormat("dd/MM/yy - HH:mm:ss");
        String stime = time.format(new Date());
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Role has been created.");
        eb.addField("Name:", e.getRole().getName(), false);
        eb.addField("ID:", e.getRole().getIdLong() + "", false);
        eb.addField("Permissions:", e.getRole().getPermissionsRaw() + "", false);
        eb.setFooter(stime);
		eb.setColor(gl.green);
        gl.sendMsg(eb, g);
	}

}