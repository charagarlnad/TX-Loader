package glowredman.txloader;

import java.util.List;

@SuppressWarnings("unused")
public class MinecraftHook {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List insertForcePack(List resourcePackList) {
        resourcePackList.add(new TXResourcePack.Force());
        return resourcePackList;
    }
}
