/*
 * Copyright 2018-2021 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.naver.maps.map.demo.java.overlay;

import java.util.Arrays;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.demo.R;
import com.naver.maps.map.overlay.ArrowheadPathOverlay;

public class ArrowheadPathOverlayActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static final List<LatLng> COORDS = Arrays.asList(
        new LatLng(37.568003, 126.9772503),
        new LatLng(37.5701573, 126.9772503),
        new LatLng(37.5701573, 126.9793745));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_map_fragment);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        MapFragment mapFragment = (MapFragment)getSupportFragmentManager().findFragmentById(R.id.map_fragment);
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.map_fragment, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        ArrowheadPathOverlay arrowheadPathOverlay = new ArrowheadPathOverlay();
        arrowheadPathOverlay.setCoords(COORDS);
        arrowheadPathOverlay.setWidth(getResources().getDimensionPixelSize(R.dimen.arrowhead_path_overlay_width));
        arrowheadPathOverlay.setColor(Color.WHITE);
        arrowheadPathOverlay.setOutlineWidth(
            getResources().getDimensionPixelSize(R.dimen.arrowhead_path_overlay_outline_width));
        arrowheadPathOverlay.setOutlineColor(ResourcesCompat.getColor(getResources(), R.color.primary, getTheme()));
        arrowheadPathOverlay.setMap(naverMap);
    }
}
