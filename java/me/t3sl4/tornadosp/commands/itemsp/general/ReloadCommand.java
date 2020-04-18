package me.t3sl4.tornadosp.commands.itemsp.general;

import me.t3sl4.tornadosp.api.API;
import me.t3sl4.tornadosp.api.Styles;
import me.t3sl4.tornadosp.commands.CommandInterface;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandInterface {
   public void onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
      API.ayarlar.load();
      API.spawnerlar.load();
      new Styles();
      sender.sendMessage(Styles.Files_Has_Been_Reloaded);
   }
}
