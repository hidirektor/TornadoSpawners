package me.t3sl4.tornadosp.commands.itemsp.spawner;

import java.util.ArrayList;
import java.util.Iterator;
import me.t3sl4.tornadosp.api.Styles;
import me.t3sl4.tornadosp.commands.CommandInterface;
import me.t3sl4.tornadosp.serialize.ItemSpawnerType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class ListeleCommand implements CommandInterface {
   private StringBuilder liste = this.a();

   public void onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
      sender.sendMessage(this.liste.toString());
   }

   private StringBuilder a() {
      this.liste = new StringBuilder();
      this.liste.append(Styles.Help_Prefix).append("\n");
      ArrayList<String> listele = new ArrayList();
      Iterator var3 = Styles.ItemSpawner_Types.iterator();

      while(var3.hasNext()) {
         ItemSpawnerType type = (ItemSpawnerType)var3.next();
         listele.add(type.getSpawnerid());
      }

      this.liste.append(Styles.Spawner_List.replaceAll("%Spawner_List%", listele.toString()));
      return this.liste;
   }
}
