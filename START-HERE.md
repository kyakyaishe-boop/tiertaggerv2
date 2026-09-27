# TierTagger 26.2 — GitHub Browser Upload

This version is intentionally **flat**: the Gradle project files, Java source, Fabric metadata, sync script, and data file are all at the repository root so GitHub's browser upload does not have to create `src/`, `sync/`, or other nested project folders.

## Upload
1. Create a new GitHub repository.
2. Click **Add file → Upload files**.
3. Drag/select the files in this ZIP and commit them.
4. GitHub Actions requires workflow files to live under `.github/workflows/`. If your browser upload will not accept the hidden `.github` folder, open **Actions → set up a workflow yourself**, create `.github/workflows/build.yml`, and paste the contents of the included root-level `build.yml`.
5. Commit the workflow.
6. Open **Actions → Build TierTagger → Run workflow**.
7. Open the completed run and download the **TierTagger-26.2** artifact.

## Why there is a root `build.yml`
GitHub only runs Actions workflows from `.github/workflows/`. The root copy is provided so you can paste it into GitHub if the browser blocks hidden folders.

## After building
The jar is generated in `build/libs/`. The Discord sync workflow is separate and does not require a new jar when tier data changes.
