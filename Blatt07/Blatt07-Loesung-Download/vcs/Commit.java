public class Commit extends ListFiles implements Modifying {

    public Commit(VCS vcs) {
        super(vcs);
    }

    @Override
    public void execute() {
        String ts = Util.getTimestamp();
        String backupDir = getVCS().getBackupDir();
        String rootDir = getVCS().getRootDir();
        String newDir = Util.appendFileOrDirname(backupDir, ts);
        Util.mkdir(newDir);
        for (String file: Util.listFiles(backupDir)) {
            String src = Util.appendFileOrDirname(backupDir, file);
            String dest = Util.appendFileOrDirname(newDir, file);
            Util.moveFile(src, dest);
        }
        for (String file: Util.listFiles(rootDir)) {
            String src = Util.appendFileOrDirname(rootDir, file);
            String dest = Util.appendFileOrDirname(backupDir, file);
            Util.copyFile(src, dest);
        }
        System.out.println("Committed the following files:");
        super.execute();
    }

    @Override
    public String getInformation() {
        return "\nFiles: Copy and Move\nDirectory: create";
    }
}
