# TierTagger 26.2

A Fabric 26.2 client mod that keeps a local tier database synchronized from a JSON file generated from the Discord `#results` channel.

## Architecture

Discord `#results` -> GitHub Actions sync job -> `data/tiers.json` -> Minecraft TierTagger mod

The Minecraft `.jar` does **not** contain a Discord bot token. The Discord token stays in GitHub Actions Secrets.

## What is included

- - `sync_tiers.py` / `requirements.txt` - Discord result parser
- `data/tiers.json` - generated tier database
- `.github/workflows/build.yml` - builds the Minecraft jar
- `.github/workflows/sync-tiers.yml` - polls Discord and updates `data/tiers.json`

## Discord setup

1. Create a Discord application/bot in the Discord Developer Portal.
2. Invite the bot to the server with permission to view the `#results` channel and read message history.
3. Enable the Message Content privileged intent if your server/bot configuration requires it for reading message data. Discord has current requirements around access to message content.
4. Copy the bot token into GitHub repository Secrets as `DISCORD_BOT_TOKEN`.
5. Put the `#results` channel ID into `DISCORD_CHANNEL_ID`.
6. Commit/push this project to GitHub.
7. The sync workflow will update `data/tiers.json` when new results are found.

## GitHub Secrets / Variables

Recommended:
- Secret: `DISCORD_BOT_TOKEN`
- Repository variable: `DISCORD_CHANNEL_ID`
- Repository variable: `TIERTAGGER_DATA_URL`

`TIERTAGGER_DATA_URL` should be the raw URL to `data/tiers.json` on the repository's default branch.

## Minecraft use

The mod periodically checks the configured JSON URL. It keeps a cached copy under the Minecraft config directory, so a temporary network failure does not erase existing tiers.

Press the default keybind **Right Shift** to open the TierTagger screen.

The screen lets you search for a player and shows their known gamemode/tier entries.

## Important

The project intentionally does not contain a Discord token. Never put a bot token in the Minecraft jar, source repository, or client config.
