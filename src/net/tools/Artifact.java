package net.tools;

public abstract class Artifact implements Validatable, Comparable<Artifact> {
    abstract public long getId();
}
