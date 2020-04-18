package me.t3sl4.tornadosp.commands;

import java.util.HashMap;
import me.t3sl4.tornadosp.TornadoSpawnersPlugin;
import me.t3sl4.tornadosp.api.Styles;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHandler implements CommandExecutor {
   private HashMap<String, CommandInterface> args = new HashMap();
   private String commandLabel;
   private StringBuilder helpmessage = this.a();

   public CommandHandler(String commandLabel) {
      this.commandLabel = commandLabel;
   }

   public void addArgs(String args, CommandInterface arg) {
      this.args.put(args, arg);
   }

   private boolean exists(String args) {
      return this.args.containsKey(args);
   }

   private CommandInterface getExecutor(String args) {
      return (CommandInterface)this.args.get(args);
   }

   public void build() {
      TornadoSpawnersPlugin.getPlugin().getCommand(this.commandLabel).setExecutor(this);
   }

   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
      if (args.length == 0) {
         if (sender.isOp()) {
            sender.sendMessage(this.helpmessage.toString());
         } else {
            sender.sendMessage(Styles.Player_Help_Message);
         }
      }

      if (args.length <= 0) {
         return false;
      } else if (!sender.isOp()) {
         sender.sendMessage(Styles.Player_Help_Message);
         return false;
      } else if (this.exists(args[0])) {
         this.getExecutor(args[0]).onCommand(sender, cmd, commandLabel, args);
         return true;
      } else {
         sender.sendMessage(this.helpmessage.toString());
         return false;
      }
   }

   private StringBuilder a() {
      this.helpmessage = new StringBuilder();
      this.helpmessage.append(Styles.Help_Prefix).append("\n");
      this.helpmessage.append(Styles.Help_Give).append("\n");
      this.helpmessage.append(Styles.Help_Deal).append("\n");
      this.helpmessage.append(Styles.Help_List).append("\n");
      this.helpmessage.append(Styles.Help_Reload);
      return this.helpmessage;
   }
}
