package com.doodle.spearsmod;


import com.doodle.spearsmod.config.SimpleSpearsConfig;
import com.doodle.spearsmod.init.modenchantments;
import com.doodle.spearsmod.init.modentities;
import com.doodle.spearsmod.init.moditemgroups;
import com.doodle.spearsmod.init.moditems;
import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleSpears implements ModInitializer {
	public static final String MOD_ID = "spearsmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);




	@Override
	public void onInitialize() {
		moditems.registerModItems();
		moditemgroups.registerModItemGroups();
		modentities.registerModEntities();
		modenchantments.registerModEnchantments();
		MidnightConfig.init("spearsmod", SimpleSpearsConfig.class);


	}

}