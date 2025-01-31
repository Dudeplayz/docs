import 'Frontend/demo/init'; // hidden-source-line
import './upload-demo-helpers'; // hidden-source-line
import '@vaadin/upload';
import { html, LitElement } from 'lit';
import { customElement } from 'lit/decorators.js';
import type { UploadI18n } from '@vaadin/upload';
import { applyTheme } from 'Frontend/generated/theme';

@customElement('upload-internationalization')
export class Example extends LitElement {
  protected override createRenderRoot() {
    const root = super.createRenderRoot();
    // Apply custom theme (only supported if your app uses one)
    applyTheme(root);
    return root;
  }

  // tag::snippet[]
  protected override render() {
    const i18n: UploadI18n = {
      dropFiles: {
        one: 'Raahaa tiedosto tähän',
        many: 'Raahaa tiedostot tähän',
      },
      addFiles: {
        one: 'Valitse tiedosto...',
        many: 'Valitse tiedostot...',
      },
      error: {
        tooManyFiles: 'Liian monta tiedostoa.',
        fileIsTooBig: 'Tiedosto on liian suuri.',
        incorrectFileType: 'Väärä tiedostomuoto.',
      },
      uploading: {
        status: {
          connecting: 'Yhdistetään...',
          stalled: 'Pysäytetty',
          processing: 'Käsitellään tiedostoa...',
          held: 'Jonossa',
        },
        remainingTime: {
          prefix: 'aikaa jäljellä: ',
          unknown: 'jäljellä olevaa aikaa ei saatavilla',
        },
        error: {
          serverUnavailable: 'Palvelin ei vastaa',
          unexpectedServerError: 'Palvelinvirhe',
          forbidden: 'Kielletty',
        },
      },
      units: {
        size: ['t', 'kt', 'Mt', 'Gt', 'Tt', 'Pt', 'Et', 'ZB', 'YB'],
        sizeBase: 1000,
      },
    };
    return html`<vaadin-upload .i18n="${i18n}"></vaadin-upload>`;
  }
  // end::snippet[]
}
