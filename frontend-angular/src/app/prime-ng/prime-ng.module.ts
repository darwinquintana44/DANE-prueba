import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ButtonModule} from 'primeng/button';
import {CardModule} from 'primeng/card';
import {TableModule} from 'primeng/table';
import {DropdownModule} from 'primeng/dropdown';
import {DialogModule} from 'primeng/dialog';
import {InputTextModule} from 'primeng/inputtext';
import {PasswordModule} from 'primeng/password';
import {FloatLabelModule} from 'primeng/floatlabel';
import {SelectModule} from 'primeng/select';
import {MenubarModule} from 'primeng/menubar';
import {DatePickerModule} from 'primeng/datepicker';
import {CalendarModule} from 'primeng/calendar';
import {ProgressSpinnerModule} from 'primeng/progressspinner';
import {FileUploadModule} from 'primeng/fileupload';
import {MessagesModule} from 'primeng/messages';
import {DrawerModule} from 'primeng/drawer';
import {ConfirmDialogModule} from 'primeng/confirmdialog';
import {ToastModule} from 'primeng/toast';
import {RadioButtonModule} from 'primeng/radiobutton';
import {SelectButtonModule} from 'primeng/selectbutton';
import {provideAnimationsAsync} from '@angular/platform-browser/animations/async';
import {providePrimeNG} from 'primeng/config';
import Aura from '@primeng/themes/aura';



@NgModule({
  exports: [
    ButtonModule,
    CardModule,
    TableModule,
    DropdownModule,
    DialogModule,
    InputTextModule,
    PasswordModule,
    FloatLabelModule,
    SelectModule,
    MenubarModule,
    DatePickerModule,
    CalendarModule,
    ProgressSpinnerModule,
    FileUploadModule,
    MessagesModule,
    DrawerModule,
    ConfirmDialogModule,
    ToastModule,
    RadioButtonModule,
    SelectButtonModule,
  ],
  providers: [
    provideAnimationsAsync(),
    providePrimeNG({
      theme: {
        preset: Aura,
        // options: {
        //   darkModeSelector: '.never-dark' // Clase ficticia para desactivar el modo oscuro
        // }
      }
    })
  ]
})
export class PrimeNgModule { }
