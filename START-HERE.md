# TierTagger 26.2 — GitHub Browser Build

## Fix for "No Gradle build results detected"

This version uses the current Fabric 26.2 build setup and does **not** require you to upload a Gradle wrapper. GitHub Actions installs Gradle 9.5.1 and Java 25 automatically.

## GitHub browser upload

1. Create an empty GitHub repository.
2. Extract this ZIP.
3. Upload all visible files and folders to the repository.
4. If GitHub's browser hides `.github`, create these two files in the GitHub editor:
   - `.github/workflows/build.yml`
   - `.github/workflows/sync-tiers.yml`
   and copy the matching files from this ZIP.
5. Open **Actions** → **Build TierTagger 26.2** → **Run workflow**.
6. Wait for the green check.
7. Open the completed run and download the **TierTagger-26.2** artifact.

The Minecraft jar is produced at `build/libs/tiertagger-1.0.0.jar`.

## Automatic tier updates

The Minecraft jar reads the JSON URL from `config/tiertagger.json`. The default URL should point to this repository's `data/tiers.json` after you edit it to your GitHub username/repository.

The Discord sync workflow needs:
- Repository secret: `DISCORD_BOT_TOKEN`
- Repository variable: `DISCORD_CHANNEL_ID`

Do not put the Discord bot token inside the Minecraft jar or commit it to GitHub.
