package com.anderson.testco.factory;

import com.anderson.testco.coverage.*;

public class CoverageFactory {
    public static Coverage fromCoverageName(String coverageName) {
        switch (coverageName) {
            case "Mega Coverage": return new MegaCoverage();
            case "Full Coverage": return new FullCoverage();
            case "Special Full Coverage": return new SpecialFullCoverage();
            default: return new CommonCoverage();
        }
    }
}
