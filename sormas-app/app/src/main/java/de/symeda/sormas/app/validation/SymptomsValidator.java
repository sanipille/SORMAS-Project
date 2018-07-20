package de.symeda.sormas.app.validation;

import android.content.Context;

import de.symeda.sormas.api.utils.ValidationException;
import de.symeda.sormas.app.databinding.FragmentSymptomsEditLayoutBinding;

/**
 * Created by Mate Strysewske on 21.07.2017.
 */
public final class SymptomsValidator {

    public static void validateSymptoms(Context context, FragmentSymptomsEditLayoutBinding contentBinding) throws ValidationException {
        ValidationErrorInfo errorInfo = FragmentValidator.validateFragmentRequirements(context, contentBinding);

        if (errorInfo.hasError()) {
            throw new ValidationException(errorInfo.toString());
        }
    }

//    public static boolean validateCaseSymptoms(Symptoms symptoms, CaseSymptomsFragmentLayoutBinding binding) {
//        Resources resources = DatabaseHelper.getContext().getResources();
//
//        boolean success = true;
//
//        List<SymptomStateField> nonConditionalSymptoms = getNonConditionalSymptoms(binding);
//        List<SymptomStateField> conditionalBleedingSymptoms = getConditionalBleedingSymptoms(binding);
//        List<SymptomStateField> lesionsFields = getLesionsFields(binding);
//        List<SymptomStateField> monkeypoxFields = getMonkeypoxFields(binding);
//
//        // Other clinical symptoms
//        if (symptoms.getOtherNonHemorrhagicSymptoms() == SymptomState.YES &&
//                (symptoms.getOtherNonHemorrhagicSymptomsText() == null || symptoms.getOtherNonHemorrhagicSymptomsText().trim().isEmpty())) {
//            binding.symptomsOther1NonHemorrhagicSymptomsText.setError(resources.getString(R.string.validation_symptoms_other_clinical));
//            success = false;
//        }
//
//        // Other hemorrhagic symptoms
//        if (symptoms.getOtherHemorrhagicSymptoms() == SymptomState.YES &&
//                (symptoms.getOtherHemorrhagicSymptomsText() == null || symptoms.getOtherHemorrhagicSymptomsText().trim().isEmpty())) {
//            binding.symptomsOther1HemorrhagicSymptomsText.setError(resources.getString(R.string.validation_symptoms_other_hemorrhagic));
//            success = false;
//        }
//
//        // Unexplained bleeding symptoms
//        if (symptoms.getUnexplainedBleeding() == SymptomState.YES) {
//            if (markAnySymptomSetTo(null, conditionalBleedingSymptoms, resources)) {
//                success = false;
//            }
//        }
//
//        // Lesions fields
//        if (symptoms.getLesions() == SymptomState.YES) {
//            if (markAnySymptomSetTo(null, lesionsFields, resources)) {
//                success = false;
//            }
//        }
//
//        // Monkeypox fields
//        if (symptoms.getLesions() == SymptomState.YES) {
//            if (markAnySymptomSetTo(null, monkeypoxFields, resources)) {
//                success = false;
//            }
//        }
//
//        return success;
//    }
//
//    public static boolean validateVisitSymptoms(Visit visit, Symptoms symptoms, CaseSymptomsFragmentLayoutBinding binding) {
//        Resources resources = DatabaseHelper.getContext().getResources();
//
//        boolean success = true;
//
//        List<SymptomStateField> nonConditionalSymptoms = getNonConditionalSymptoms(binding);
//        List<SymptomStateField> conditionalBleedingSymptoms = getConditionalBleedingSymptoms(binding);
//        List<SymptomStateField> lesionsFields = getLesionsFields(binding);
//        List<SymptomStateField> monkeypoxFields = getMonkeypoxFields(binding);
//
//        // Other clinical symptoms
//        if (symptoms.getOtherNonHemorrhagicSymptoms() == SymptomState.YES &&
//                (symptoms.getOtherNonHemorrhagicSymptomsText() == null || symptoms.getOtherNonHemorrhagicSymptomsText().trim().isEmpty())) {
//            binding.symptomsOther1NonHemorrhagicSymptomsText.setError(resources.getString(R.string.validation_symptoms_other_clinical));
//            success = false;
//        }
//
//        // Other hemorrhagic symptoms
//        if (symptoms.getOtherHemorrhagicSymptoms() == SymptomState.YES &&
//                (symptoms.getOtherHemorrhagicSymptomsText() == null || symptoms.getOtherHemorrhagicSymptomsText().trim().isEmpty())) {
//            binding.symptomsOther1HemorrhagicSymptomsText.setError(resources.getString(R.string.validation_symptoms_other_hemorrhagic));
//            success = false;
//        }
//
//        // Unexplained bleeding symptoms
//        if (symptoms.getUnexplainedBleeding() == SymptomState.YES) {
//            if (markAnySymptomSetTo(null, conditionalBleedingSymptoms, resources)) {
//                success = false;
//            }
//        }
//
//        // Lesions fields
//        if (symptoms.getLesions() == SymptomState.YES) {
//            if (markAnySymptomSetTo(null, lesionsFields, resources)) {
//                success = false;
//            }
//        }
//
//        // Monkeypox fields
//        if (symptoms.getLesions() == SymptomState.YES) {
//            if (markAnySymptomSetTo(null, monkeypoxFields, resources)) {
//                success = false;
//            }
//        }
//
//        if (visit.getVisitStatus() == VisitStatus.COOPERATIVE) {
//            // Non-conditional symptoms
//            if (markAnySymptomSetTo(null, nonConditionalSymptoms, resources)) {
//                success = false;
//            }
//            // Temperature & fever
//            if (symptoms.getTemperature() != null && (symptoms.getTemperature().compareTo(38.0F) >= 0 && symptoms.getFever() != SymptomState.YES)) {
//                binding.symptomsFever.setError(resources.getString(R.string.validation_symptoms_fever));
//                success = false;
//            }
//        }
//
//        return success;
//    }
//
//    public static void clearErrorsForSymptoms(CaseSymptomsFragmentLayoutBinding binding) {
//        for (SymptomStateField field : getNonConditionalSymptoms(binding)) {
//            field.clearError();
//        }
//
//        for (SymptomStateField field : getConditionalBleedingSymptoms(binding)) {
//            field.clearError();
//        }
//
//        for (PropertyField field : getOtherSymptomsFields(binding)) {
//            field.clearError();
//        }
//
//        for (PropertyField field : getLesionsFields(binding)) {
//            field.clearError();
//        }
//
//        for (PropertyField field : getMonkeypoxFields(binding)) {
//            field.clearError();
//        }
//    }
//
//    public static void setRequiredHintsForCaseSymptoms(CaseSymptomsFragmentLayoutBinding binding) {
//        // Reset required hints
//        resetRequiredHints(binding);
//
//        // Always required because these fields are only visible when they are actually required
//        for (SymptomStateField field : getConditionalBleedingSymptoms(binding)) {
//            field.setRequiredHint(true);
//        }
//        for (SymptomStateField symptom : getLesionsFields(binding)) {
//            symptom.setRequiredHint(true);
//        }
//        for (SymptomStateField symptom : getMonkeypoxFields(binding)) {
//            symptom.setRequiredHint(true);
//        }
//        binding.symptomsOther1NonHemorrhagicSymptomsText.setRequiredHint(true);
//        binding.symptomsOther1HemorrhagicSymptomsText.setRequiredHint(true);
//    }
//
//    public static void setSoftRequiredHintsForCaseSymptoms(CaseSymptomsFragmentLayoutBinding binding) {
//        for (SymptomStateField field : getNonConditionalSymptoms(binding)) {
//            if (field.getFieldValue() == SymptomState.YES) {
//                binding.symptomsOnsetDate.makeFieldSoftRequired();
//                binding.symptomsOnsetSymptom.makeFieldSoftRequired();
//                return;
//            }
//        }
//
//        binding.symptomsOnsetDate.removeSoftRequirement();
//        binding.symptomsOnsetSymptom.removeSoftRequirement();
//    }
//
//    public static void setSoftRequiredHintsForVisitSymptoms(boolean cooperative, CaseSymptomsFragmentLayoutBinding binding) {
//        if (cooperative) {
//            for (SymptomStateField field : getNonConditionalSymptoms(binding)) {
//                if (field.getFieldValue() == SymptomState.YES) {
//                    binding.symptomsOnsetDate.makeFieldSoftRequired();
//                    binding.symptomsOnsetSymptom.makeFieldSoftRequired();
//                    binding.symptomsTemperature.makeFieldSoftRequired();
//                    binding.symptomsTemperatureSource.makeFieldSoftRequired();
//                    return;
//                }
//            }
//        }
//
//        binding.symptomsOnsetDate.removeSoftRequirement();
//        binding.symptomsOnsetSymptom.removeSoftRequirement();
//        binding.symptomsTemperature.removeSoftRequirement();
//        binding.symptomsTemperatureSource.removeSoftRequirement();
//    }
//
//    public static void setRequiredHintsForVisitSymptoms(boolean cooperative, CaseSymptomsFragmentLayoutBinding binding) {
//        // Reset required hints
//        resetRequiredHints(binding);
//
//        // Set required hints
//        if (cooperative) {
//            for (SymptomStateField field : getNonConditionalSymptoms(binding)) {
//                field.setRequiredHint(true);
//            }
//        }
//
//        // Always required because these fields are only visible when they are actually required
//        for (SymptomStateField field : getConditionalBleedingSymptoms(binding)) {
//            field.setRequiredHint(true);
//        }
//        for (SymptomStateField symptom : getLesionsFields(binding)) {
//            symptom.setRequiredHint(true);
//        }
//        for (SymptomStateField symptom : getMonkeypoxFields(binding)) {
//            symptom.setRequiredHint(true);
//        }
//        binding.symptomsOther1NonHemorrhagicSymptomsText.setRequiredHint(true);
//        binding.symptomsOther1HemorrhagicSymptomsText.setRequiredHint(true);
//    }
//
//    private static void resetRequiredHints(CaseSymptomsFragmentLayoutBinding binding) {
//        // Reset required hints
//        for (SymptomStateField field : getNonConditionalSymptoms(binding)) {
//            field.setRequiredHint(false);
//        }
//        for (SymptomStateField field : getConditionalBleedingSymptoms(binding)) {
//            field.setRequiredHint(false);
//        }
//        for (PropertyField field : getOtherSymptomsFields(binding)) {
//            field.setRequiredHint(false);
//        }
//        for (SymptomStateField field : getLesionsFields(binding)) {
//            field.setRequiredHint(false);
//        }
//        for (SymptomStateField field : getMonkeypoxFields(binding)) {
//            field.setRequiredHint(false);
//        }
//    }
//
//    public static boolean isSymptomatic(CaseSymptomsFragmentLayoutBinding binding) {
//        return isAnySymptomSetTo(SymptomState.YES, getNonConditionalSymptoms(binding)) ||
//                (binding.symptomsTemperature.getFieldValue() != null && (Float) binding.symptomsTemperature.getFieldValue() >= 38.0f);
//    }
//
//    /**
//     * Returns true if there is any visible non-conditional symptom set to the given symptom state
//     * or null, in which case true is returned if any symptom state is not set
//     */
//    private static boolean isAnySymptomSetTo(SymptomState reqSymptomState, List<SymptomStateField> nonConditionalSymptoms) {
//        for(SymptomStateField field : nonConditionalSymptoms) {
//            if(field.getVisibility() == View.VISIBLE && field.getFieldValue() == reqSymptomState) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    /**
//     * Returns true if there is any visible conditional bleeding symptom set to the given symptom state
//     * or null, in which case true is returned if any symptom state is not set
//     */
//    private static boolean markAnySymptomSetTo(SymptomState reqSymptomState, List<SymptomStateField> symptomsList, Resources resources) {
//        boolean fieldMarked = false;
//        for(SymptomStateField field : symptomsList) {
//            if(field.getVisibility() == View.VISIBLE && field.getFieldValue() == reqSymptomState) {
//                field.setError(resources.getString(R.string.validation_symptoms_symptom));
//                fieldMarked = true;
//            }
//        }
//
//        return fieldMarked;
//    }
//
//
//
//
//
//
//    private static List<SymptomStateField> getNonConditionalSymptoms(CaseSymptomsFragmentLayoutBinding binding) {
//        // These should be in reverse order of how they're displayed on the screen
//        return Arrays.asList(binding.symptomsOtherNonHemorrhagicSymptoms, binding.symptomsVomiting, binding.symptomsUnexplainedBleeding, binding.symptomsThrobocytopenia, binding.symptomsSwollenGlands,
//                binding.symptomsSoreThroat, binding.symptomsSkinRash, binding.symptomsShock, binding.symptomsOralUlcers, binding.symptomsRunnyNose,
//                binding.symptomsRefusalFeedorDrink, binding.symptomsRapidBreathing, binding.symptomsPainfulLymphadenitis, binding.symptomsNeckStiffness,
//                binding.symptomsNausea, binding.symptomsMusclePain, binding.symptomsOtitisMedia, binding.symptomsLymphadenopathyInguinal, binding.symptomsLymphadenopathyCervical,
//                binding.symptomsLymphadenopathyAxillary, binding.symptomsLesions, binding.symptomsKopliksSpots, binding.symptomsJointPain, binding.symptomsJaundice,
//                binding.symptomsBedridden, binding.symptomsHiccups, binding.symptomsHeadache, binding.symptomsFever, binding.symptomsFatigueWeakness,
//                binding.symptomsEyePainLightSensitive, binding.symptomsDifficultyBreathing, binding.symptomsDiarrhea, binding.symptomsDehydration,
//                binding.symptomsDarkUrine, binding.symptomsCough, binding.symptomsSeizures, binding.symptomsConjunctivitis,
//                binding.symptomsConfusedDisoriented, binding.symptomsChillsSweats, binding.symptomsChestPain, binding.symptomsBuboesGroinArmpitNeck,
//                binding.symptomsBloodInStool, binding.symptomsBlackeningDeathOfTissue, binding.symptomsBackache, binding.symptomsAnorexiaAppetiteLoss,
//                binding.symptomsAlteredConsciousness, binding.symptomsHearingloss, binding.symptomsAbdominalPain, binding.symptomsBulgingFontanelle,
//                binding.symptomsMeningealSigns);
//    }
//
//    private static List<SymptomStateField> getConditionalBleedingSymptoms(CaseSymptomsFragmentLayoutBinding binding) {
//        // These should be in reverse order of how they're displayed on the screen
//        return Arrays.asList(binding.symptomsOtherHemorrhagicSymptoms, binding.symptomsRedBloodVomit, binding.symptomsDigestedBloodVomit, binding.symptomsCoughingBlood,
//                binding.symptomsSkinBruising, binding.symptomsNoseBleeding, binding.symptomsBloodyBlackStool, binding.symptomsBloodUrine, binding.symptomsGumsBleeding,
//                binding.symptomsBleedingVagina, binding.symptomsInjectionSiteBleeding, binding.symptomsStomachBleeding, binding.symptomsEyesBleeding);
//    }
//
//    private static List<SymptomStateField> getLesionsFields(CaseSymptomsFragmentLayoutBinding binding) {
//        return Arrays.asList(binding.symptomsLesionsDeepProfound, binding.symptomsLesionsSameSize, binding.symptomsLesionsSameState, binding.symptomsLesionsThatItch);
//    }
//
//    private static List<SymptomStateField> getMonkeypoxFields(CaseSymptomsFragmentLayoutBinding binding) {
//        return Arrays.asList(binding.symptomsLesionsResembleImg4, binding.symptomsLesionsResembleImg3, binding.symptomsLesionsResembleImg2, binding.symptomsLesionsResembleImg1);
//    }
//
//    private static List<PropertyField<?>> getOtherSymptomsFields(CaseSymptomsFragmentLayoutBinding binding) {
//        return Arrays.asList(binding.symptomsOnsetDate, binding.symptomsOnsetSymptom,
//                binding.symptomsOther1HemorrhagicSymptomsText, binding.symptomsOther1NonHemorrhagicSymptomsText,
//                binding.symptomsTemperature, binding.symptomsTemperatureSource, binding.symptomsPatientIllLocation);
//    }
}
