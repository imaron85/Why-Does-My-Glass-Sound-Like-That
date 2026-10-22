# Why Does My Glass Sound Like That

> **Unofficial Minecraft 26.3 port** (branch `26.3`) of Why Does My Glass Sound Like That by spjoes / IAmThePerson,
> https://github.com/spjoes/Why-Does-My-Glass-Sound-Like-That (CC0-1.0). Not affiliated with or endorsed by the original author.
> Port changes: Mojang names / no-remap Loom / Java 25; glass, tinted glass, stained glass and all panes are matched on
> the client, so the mod also works on vanilla servers (which never send the mod's block tag); the sound event is played
> by id from `sounds.json` instead of being registered in the sound event registry.

Over 3 years ago now, Dinnerbone tweeted out that the glass sound should change when you use a Silk Touch pickaxe so the audio feedback doesn't make you think, quote, ["crap, wrong tool"](https://twitter.com/Dinnerbone/status/1434546463137308675).

This client-side Fabric mod does exactly that. When you break glass with a Silk Touch pickaxe, you will now be greeted to a new sound that doesn't break your ear drums!

## Features

- Replaces glass break sound when Silk Touch is used.
- Covers glass, stained glass, glass panes, and tinted glass.
- Client-side. No need to install it on any server.

## Compatibility

- Minecraft Java Edition `26.3`
- Fabric Loader `0.19.3+` (or Quilt Loader `0.30.2-beta.1+`)
- Fabric API
- Java `25+`

## Installation

1. Install Fabric Loader for your Minecraft version.
2. Install Fabric API.
3. Place the mod `.jar` in your `mods` folder.
4. Launch the game.

## Links

- Discord: https://discord.gg/gM7KXYXUDM
- Source: https://github.com/spjoes/Why-Does-My-Glass-Sound-Like-That

## Development

Build locally with:

```bash
./gradlew build
```

On Windows:

```bat
gradlew.bat build
```

## License

CC0-1.0
