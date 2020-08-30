FROM node:12.13.0
WORKDIR /app
COPY package.json /app/package.json
RUN npm install
RUN npm i @angular/cli@9.1.0
COPY . .
CMD ["ng","serve"]
