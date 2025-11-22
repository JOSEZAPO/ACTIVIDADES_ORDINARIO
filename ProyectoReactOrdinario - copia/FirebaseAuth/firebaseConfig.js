import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";

const firebaseConfig = {
  apiKey: "AIzaSyA75i4K0qsnEIrEd3-4qB2Mc_jbbnxsuIY",
  authDomain: "demofirebaseauth-6e566.firebaseapp.com",
  projectId: "demofirebaseauth-6e566",
  storageBucket: "demofirebaseauth-6e566.firebasestorage.app",
  messagingSenderId: "285825289461",
  appId: "1:285825289461:web:f643ba6ce7cd5776c9c9bc"
};

const app = initializeApp(firebaseConfig);

export const auth = getAuth(app);
