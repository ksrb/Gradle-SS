package chapter.four

class Version {
    int major, minor
    boolean playground, release

    Version(boolean playground, int major, int minor, boolean release) {
        this.playground = playground
        this.major = major
        this.minor = minor
        this.release = release
    }

    Version(int major, int minor) {
        this(false, major, minor, false)
    }

    @Override
    String toString() {
        "${playground ? 'Playground' : ''} $major.$minor${release ? '' : '-SNAPSHOT'}"
    }
}