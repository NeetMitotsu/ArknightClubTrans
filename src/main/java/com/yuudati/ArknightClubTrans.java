package com.yuudati;

import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.contact.ContactList;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.contact.NormalMember;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.MessageChain;

import java.util.List;

public final class ArknightClubTrans extends JavaPlugin {
    public static final ArknightClubTrans INSTANCE = new ArknightClubTrans();

    private ArknightClubTrans() {
        super(new JvmPluginDescriptionBuilder("com.yuudati.ArknightClubTrans", "1.0-SNAPSHOT")
                .name("ArknightClubTransPlugin")
                .info("明日方舟线索交换插件")
                .author("Neet")
                .build());

        // 创建监听
        Listener<GroupMessageEvent> subscribe = GlobalEventChannel.INSTANCE
//                .exceptionHandler(e -> e.printStackTrace())
                .subscribeAlways(GroupMessageEvent.class, event -> {
                    MessageChain chain = event.getMessage(); // 可获取到消息内容等, 详细查阅 `GroupMessageEvent`
                    if (chain.contains("/ 线索交换")) {
                        event.getSubject().sendMessage("输入需要交换的线索"); // 回复消息
                        // 开始保存
                    }
                });
    }

    @Override
    public void onEnable() {
        getLogger().info("Plugin loaded!");
    }


}