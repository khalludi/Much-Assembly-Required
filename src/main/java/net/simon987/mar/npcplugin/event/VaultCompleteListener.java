package net.simon987.mar.npcplugin.event;

import net.simon987.mar.server.event.GameEvent;
import net.simon987.mar.server.event.GameEventListener;
import net.simon987.mar.server.game.objects.ControllableUnit;
import net.simon987.mar.server.game.objects.GameObject;
import net.simon987.mar.server.logging.LogManager;

public class VaultCompleteListener implements GameEventListener {
    @Override
    public Class getListenedEventType() {
        return VaultCompleteEvent.class;
    }

    @Override
    public void handle(GameEvent event) {
        VaultCompleteEvent vaultCompleteEvent = (VaultCompleteEvent) event;
        GameObject object = vaultCompleteEvent.getSource();
        if (object instanceof ControllableUnit) {
            LogManager.LOGGER.info(((ControllableUnit) object).getParent().getUsername() + " Completed vault " +
                    object.getWorld().getDimension());

            ((ControllableUnit) object).getParent().getStats().addToStringSet("completedVaults",
                    vaultCompleteEvent.getPortal().getWorld().getDimension());
        }
    }
}