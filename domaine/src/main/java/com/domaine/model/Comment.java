package com.domaine.model;


public class Comment {

        private int id;

        private final String content;

        private final CelestialObject celestialObject;

        private final AppUser appuser;

        public Comment(String content, CelestialObject celestialObject, AppUser appuser) {
            this.content = content;
            this.celestialObject = celestialObject;
            this.appuser = appuser;
        }


    }

