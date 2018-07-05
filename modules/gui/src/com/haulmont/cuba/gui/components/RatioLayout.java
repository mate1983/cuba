package com.haulmont.cuba.gui.components;

/**
 * Component container which supports expand ratio of components
 */
public interface RatioLayout {

    /**
     * Sets expand ratio for the component. The ratio must have a positive value.
     *
     * @param component component to expand with ratio
     * @param ratio ratio
     */
    void setExpandRatio(Component component, float ratio);

    /**
     * @param component component for which returns ratio
     * @return ratio for the component, 0.0f by default
     */
    float getExpandRatio(Component component);
}
