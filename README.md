# Bound Mod

一个简单的Minecraft 1.12.2 Forge模组，通过按键执行指定命令。

## 功能

- 按下配置的按键（默认为C键）时执行特定命令（默认为/menu）

## 自定义设置

编辑`src/main/java/com/example/examplemod/ExampleMod.java`文件：

### 修改按键和信息

```java
// 修改"Open Menu"为按键显示名称，"Bound"为分类名称
// 修改Keyboard.KEY_C为你想要的按键
public static KeyBinding menuKey = new KeyBinding("Open Menu", Keyboard.KEY_C, "Bound");
```


### 修改执行的命令

要更改按键执行的命令，编辑`onKeyInput`方法：

```java
@SubscribeEvent
@SideOnly(Side.CLIENT)
public void onKeyInput(ClientTickEvent event) {
    if (menuKey.isPressed()) {
        Minecraft.getMinecraft().player.sendChatMessage("/menu");
    }
}
```

## 构建

1. 克隆项目
2. 修改信息
3. 查看 github action 运行结果