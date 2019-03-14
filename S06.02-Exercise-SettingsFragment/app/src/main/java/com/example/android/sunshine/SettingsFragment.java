package com.example.android.sunshine;

// TODO (4) Create SettingsFragment and extend PreferenceFragmentCompat

// Do steps 5 - 11 within SettingsFragment
// TODO (10) Implement OnSharedPreferenceChangeListener from SettingsFragment

// TODO (8) Create a method called setPreferenceSummary that accepts a Preference and an Object and sets the summary of the preference

// TODO (5) Override onCreatePreferences and add the preference xml file using addPreferencesFromResource

// Do step 9 within onCreatePreference
// TODO (9) Set the preference summary on each preference that isn't a CheckBoxPreference

// TODO (13) Unregister SettingsFragment (this) as a SharedPreferenceChangedListener in onStop

// TODO (12) Register SettingsFragment (this) as a SharedPreferenceChangedListener in onStart

// TODO (11) Override onSharedPreferenceChanged to update non CheckBoxPreferences when they are changed

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceManager;

public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.prefs);
        updateSummary();
    }

    private void updateSummary() {
        SharedPreferences preferences = getPreferenceManager().getSharedPreferences();
        PreferenceManager manager = getPreferenceManager();

        String locPrefKey = getString(R.string.pref_location_key);
        String defLocValue = getString(R.string.pref_location_default);
        EditTextPreference locPref = (EditTextPreference) manager.findPreference(locPrefKey);
        locPref.setSummary(preferences.getString(locPrefKey, defLocValue));

        String unitPrefKey = getString(R.string.pref_units_key);
        ListPreference unitPref = (ListPreference) manager.findPreference(unitPrefKey);
        int index = unitPref.findIndexOfValue(unitPref.getValue());
        unitPref.setSummary(unitPref.getEntries()[index]);
    }

    @Override
    public void onStart() {
        super.onStart();

        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        updateSummary();
    }

    @Override
    public void onStop() {
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onStop();
    }
}
