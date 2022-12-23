package com.example.pifalafatec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.pifalafatec.achadoseperdidos.AchadosEPerdidosFragment;
import com.example.pifalafatec.eventos.CalendarioDeEventosFragment;
import com.learnoset.material.ui.learnosetnavigationbar.CustomNavTheme;
import com.learnoset.material.ui.learnosetnavigationbar.LearnosetNavItem;
import com.learnoset.material.ui.learnosetnavigationbar.LearnosetNavigationBar;
import com.learnoset.material.ui.learnosetnavigationbar.NavigationEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        final LearnosetNavigationBar learnosetNavigationBar = findViewById(R.id.navigationBar);
        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        final AppCompatImageButton drawerOpenBtn = findViewById(R.id.drawerOpenBtn);

        CustomNavTheme customNavTheme = new CustomNavTheme();
        customNavTheme.setSelectedItemBackgroundColor(Color.parseColor("#005264"));
        learnosetNavigationBar.setTheme(customNavTheme);


        LearnosetNavItem customItem = new LearnosetNavItem("Achados e Perdidos", com.learnoset.material.ui.learnosetnavigationbar.R.drawable.search_icon, new AchadosEPerdidosFragment(), R.id.fragmentContainer );
        learnosetNavigationBar.addNavItem(customItem);

        LearnosetNavItem customItem2 = new LearnosetNavItem("Calendário de Eventos", R.drawable.ic_baseline_calendar_month_24, new CalendarioDeEventosFragment(), R.id.fragmentContainer);
        learnosetNavigationBar.addNavItem(customItem2);

        LearnosetNavItem customItem3 = new LearnosetNavItem("Central de Mensagens", com.learnoset.material.ui.learnosetnavigationbar.R.drawable.message_icon);
        learnosetNavigationBar.addNavItem(customItem3);

        LearnosetNavItem customItem4 = new LearnosetNavItem("Central de Sugestões", R.drawable.ic_baseline_auto_awesome_24);
        learnosetNavigationBar.addNavItem(customItem4);

        learnosetNavigationBar.setEventListener(new NavigationEventListener() {
            @Override
            public void onItemSelected(int position, LearnosetNavItem selectedNavItem) {

            }
        });

        learnosetNavigationBar.setDrawerLayout(drawerLayout, LearnosetNavigationBar.DrawerGravity.LEFT);

        drawerLayout.openDrawer(GravityCompat.START);
        String nome = "Vinicius Mazon Viturino";
        learnosetNavigationBar.enableLogOutBtn(false);
        //learnosetNavigationBar.
        learnosetNavigationBar.setHeaderData(nome);
        //learnosetNavigationBar.setIconsColor(LearnosetNavigationBar.NavColors.RED);

        drawerOpenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }

    private String generateWishMessage() {

        final int getCurrentHour = Integer.parseInt(new SimpleDateFormat("HH", Locale.getDefault()).format(new Date()));

        if (getCurrentHour < 12) {
            return "Bem-vindo";
        } else if (getCurrentHour > 12 && getCurrentHour < 18) {
            return "Bem-vindo";
        } else {
            return "Bem-vindo";
        }

    }
}
