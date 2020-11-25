package com.i4bchile.passwordstrengthmvp.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.i4bchile.passwordstrengthmvp.R;
import com.i4bchile.passwordstrengthmvp.databinding.ActivityMainBinding;
import com.i4bchile.passwordstrengthmvp.presentador.IPresenterView;
import com.i4bchile.passwordstrengthmvp.presentador.PresenterView;

import java.util.WeakHashMap;

public class MainActivity extends AppCompatActivity implements IPresenterView{

    /* TODO
    Vistas

       [x] 1. Crear el proyecto usando el template de Empty Activity
       [x] 2. Agregar las vistas para ingresar la contraseña y para desplegar el resultado de la evaluación en
             el layout main_layout.xml.
       [X] 3. Definir los textos ocupados en el archivo strings.xml
       [X] 4. Inicializar las vistas usando findViewById(...) o con ButterKnife @Bind(..)

    Modelo

       [x] 5. Crear la clase Verifier que tenga un método público para evaluar la contraseña que retorne un
             entero indicando que tan robusta es la contraseña.
       [x] 6. Implementar cada regla en un método separado. Una de las formas es que cada regla retorne
             un booleano indicando si la regla se cumple
       [x] 7. Agregar test unitarios al modelo es opcional pero altamente recomendado

    Presentador

       [X] 8. Definir la interfaz de comunicación entre la vista y el presentador, como es IPresenterView.
       [x] 9. Crear el presentador con las referencias a la vista y al modelo.
       [x] 10. Definir el método para evaluar la contraseña y su resultado.

    MainActivity

       [x] 11. Implementar la interfaz IPresenterView por parte de MainActivity para hacer los cambios de texto
                y color asociados a la respuesta.
       [x] 12. Implementar el listener TextWatcher para verificar los cambios en el texto y utilizar el
                presentador para evaluar la contraseña.
     */

    ActivityMainBinding binding;
    PresenterView presenter;
    int pwdStrength=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=new PresenterView(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        binding.etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                pwdStrength=presenter.updatePasswordStrength(s.toString());
                presenter.evaluatePwdStrength(pwdStrength);
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
    }


    @Override
    public void showWeak() {
        binding.tvPwdStrength.setText(R.string.weak);
        binding.tvPwdStrength.setBackgroundColor(Color.RED);

    }

    @Override
    public void showMedium() {
        binding.tvPwdStrength.setText(R.string.medium);
        binding.tvPwdStrength.setBackgroundColor(Color.YELLOW);
    }

    @Override
    public void showStrong() {
        binding.tvPwdStrength.setText(R.string.strong);
        binding.tvPwdStrength.setBackgroundColor(Color.GREEN);

    }

    @Override
    public void showVeryStrong() {
        binding.tvPwdStrength.setText(R.string.very_strong);
        binding.tvPwdStrength.setBackgroundColor(Color.GREEN);
    }
}