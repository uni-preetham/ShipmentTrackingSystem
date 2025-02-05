
module.exports = {
    content: [
      "./src/**/*.{html,ts}", // Ensure Tailwind scans all Angular component files
      "./node_modules/primeng/**/*.{html,ts}" // Include PrimeNG components
    ],
    theme: {
      extend: {},
    },
    plugins: [require('tailwindcss-primeui')]
  };
  